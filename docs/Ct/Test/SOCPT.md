```js
%macro socpt(ind=,total=, soc=, pt=, trtgn=, trtg=, name= );

proc sql;

	create table &total.

	as select distinct &trtgn., &trtg.,

	count(distinct subjid) as _1 label='例数', count(*) as _2 label='例次', 1 as grp

	from &ind.

	group by &trtgn.;

quit;

proc sql;

	create table soc

	as select distinct &trtgn., &trtg., &soc.,

	count(distinct subjid) as _1 label='例数', count(*) as _2 label='例次', 2 as grp

	from &ind.

	group by &trtgn.,&soc.;

quit;

proc sql;

	create table pt

	as select distinct &trtgn., &trtg., &soc., &pt.,

	count(distinct subjid) as _1 label='例数', count(*) as _2 label='例次', 3 as grp

	from &ind.

	group by &trtgn.,&soc.,&pt.;

quit;

data total_soc_pt;

	length per freq $200.;

	set &total. soc pt;

	if &trtgn.=1 then per=strip(put(_1,best.))||" ("||strip(put(_1/&trtpop1.*100,8.1))||")";

	if &trtgn.=2 then per=strip(put(_1,best.))||" ("||strip(put(_1/&trtpop2.*100,8.1))||")";

	if &trtgn.=3 then per=strip(put(_1,best.))||" ("||strip(put(_1/&trtpop3.*100,8.1))||")";

	if &trtgn.=99 then per=strip(put(_1,best.))||" ("||strip(put(_1/&trtpop99.*100,8.1))||")";

	per=tranwrd(per,"100.0)","100)");

	freq=strip(put(_2,best.));

proc sort;

	by grp &soc. &pt. &trtgn.;

run;

proc transpose data=total_soc_pt out=outa prefix=_a;

	by grp &soc. &pt.;

	var per;

	id &trtgn.;

	idlabel &trtg.;

run;

proc transpose data=total_soc_pt out=outb prefix=_b;

	by grp &soc. &pt.;

	var freq;

	id &trtgn.;

	idlabel &trtg.;

run;

data out;

	merge outa outb;

	by grp &soc. &pt.;

	array num(*) _a1 _b1 _a2 _b2 _a3 _b3 _a99 _b99;

	array col(9)$200;

	do i=1 to 8;

	if mod(i,2)>0 and num(i)='' then num(i)='0 (-)';

		else if num(i)='' then num(i)='0'; 

	col(i+1)=num(i); 

	&pt.='    '||strip(&pt.);

	if grp=1 then col1="&name.";

	else col1=coalescec(&pt.,&soc.);

	end; 

	proc sort; by &soc. &pt.;

run;

data final;

	set out;

	/*排序*/

	if grp=1  then ord1=1;else ord1=999;

	if grp=2  then ord2=input(scan(_a99,1,' ('),8.);retain ord2;

	if grp=3  then ord3=input(scan(_a99,1,' ('),8.);else ord3=999;

	proc sort;

	by ord1  descending ord2 &soc. descending ord3 &pt. ;

run;

%mend;

%socpt(ind=adpr,total=pr, soc=PRBODSYS, pt=PRDECOD, trtgn=trt01an, trtg=trt01a, name=至少发生一次既往非药物治疗 );



```