```js
%macro mean(ind=adprsum, conds=%str(param="手术时长 (min)"), grp=1, var=aval, trtgn=trt01an, trtg=trt01a );
/*小数点*/
proc sql noprint;
	select max(lengthn(scan(put(&var.,best.),2,'.'))) into: dec 
	from &ind. where &conds.;
quit;
/*proc means*/
proc means data=&ind.(where=(&conds.)) noprint;
   by  &trtgn. &trtg.;
   var &var.;
   output out=mean n=n  nmiss=nmiss  mean=mean std=std median=median q1=q1 q3=q3 min=min max=max;
run;

data mean1;
   set mean;
   length nnmiss msd mq range $200.;
	if &trtgn.=1 then nnmiss=strip(put(n,best.))||" ("||strip(put(&trtpop1.-n,best.))||")";
	if &trtgn.=2 then nnmiss=strip(put(n,best.))||" ("||strip(put(&trtpop2.-n,best.))||")";
	if &trtgn.=3 then nnmiss=strip(put(n,best.))||" ("||strip(put(&trtpop3.-n,best.))||")";
	if &trtgn.=99 then nnmiss=strip(put(n,best.))||" ("||strip(put(&trtpop99.-n,best.))||")";
	msd=strip(putn(mean,put(8+min((&dec.+1)*0.1,0.4),best.))) || " (" || 
		strip(putn(std,put(8+min((&dec.+2)*0.1,0.4),best.))) || ")";
	mq=strip(putn(median,put(8+min((&dec.+1)*0.1,0.4),best.)))||" ("||
		strip(putn(q1,put(8+min((&dec.+1)*0.1,0.4),best.)))||", "||
		strip(putn(q3,put(8+min((&dec.+1)*0.1,0.4),best.)))||")";
	range=strip(putn(min,put(8+min(&dec.*0.1,0.4),best.)))||", "||
		strip(putn(max,put(8+min(&dec.*0.1,0.4),best.)));
run;

proc transpose data=mean1 out=mean2 prefix=_;
   var nnmiss msd mq range;
   id &trtgn.;
   idlabel &trtg.;
run;
data out&grp.;
	set mean2;
	length name $200.;
	grp=&grp.;
	if _name_='NNMISS' then do; name='  例数（缺失）'; ord=1; output; end;
	if _name_='MSD' then do; name='  均值（标准差）'; ord=2; output; end;
	if _name_='MQ' then do; name='  中位数（Q1，Q3）'; ord=3; output; end;
	if _name_='RANGE' then do; name='  最小值，最大值'; ord=4; output; end;
	drop _name_;
proc sort;
	by grp ord;
run;
proc datasets lib=work nolist;
delete mean:;
run;
%mend;
```

