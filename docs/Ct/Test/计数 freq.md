```js
%macro freq(ind=adsl, conds=%str(fasfl='Y'), param=AGEGR1, grp=2, race=);

data out;

	length varc $200.;

	set &ind.(where=(&conds.));

	grp=&grp.; 

	if &race.=1 and &param.^='汉族' then &param.='其他';

	varc=&param.; output;

	varc='合计'; output;

	

run;

proc freq data=out noprint;

	tables grp*varc*trt01an*trt01a /out=freq;

run;

data freq1;

	length per $200.;

	set freq;

	if trt01an=1 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop1.*100,8.1))||')';

	if trt01an=2 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop2.*100,8.1))||')';

	if trt01an=3 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop3.*100,8.1))||')';

	if trt01an=99 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop99.*100,8.1))||')';

	per=tranwrd(per,'100.0)','100)');

run;

proc transpose data=freq1(drop=count) out=tfreq(drop=_name_) prefix=_;

	by grp varc;

	var per;

	id trt01an;

	idlabel trt01a;

run;

%mend;


%macro freq(ind=adsl, conds=%str(fasfl='Y'), param=AGEGR1, grp=2, race=);

data out;

	length varc $200.;

	set &ind.(where=(&conds.));

	grp=&grp.; 

	if &race.=1 and &param.^='汉族' then &param.='其他';

	varc=&param.; output;

	varc='合计'; output;

	

run;

proc freq data=out noprint;

	tables grp*varc*trt01an*trt01a /out=freq;

run;

data freq1;

	length per $200.;

	set freq;

	if trt01an=1 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop1.*100,8.1))||')';

	if trt01an=2 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop2.*100,8.1))||')';

	if trt01an=3 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop3.*100,8.1))||')';

	if trt01an=99 then per=strip(put(count,8.0))||' ('||strip(put(count/&trtpop99.*100,8.1))||')';

	per=tranwrd(per,'100.0)','100)');

run;

proc transpose data=freq1(drop=count) out=tfreq(drop=_name_) prefix=_;

	by grp varc;

	var per;

	id trt01an;

	idlabel trt01a;

run;

%mend;



```