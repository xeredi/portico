/**
 * D93a
 * 	http://www.unece.org/trade/untdid/d93/
 * 	http://www.unece.org/fileadmin/DAM/trade/untdid/d14b/trmd/ifcsum_c.htm
 * http://content.portdebarcelona.cat/cntmng/d/d/workspace/SpacesStore/2185ccaf-a590-4dba-8a64-74d95cb929b7/GuiaDSDescarga_Carga33b.pdf%7cGuiaDSDescarga_Carga33b.pdf
 */
 grammar IfcsumD14b;

 import segments, components, fields;

 ifcsum
 :
 	unh bgm dtm* moa* ftx* cnt* pcd? gds* gr1* gr2* gr4* gr7* gr8* gr9* gr23*
 	gr27* unt
 ;

 gr1
 :
 	rff dtm*
 ;

 gr2
 :
 	gor dtm* loc* sel* ftx* gr3*
 ;

 gr3
 :
 	doc dtm?
 ;

 gr4
 :
 	nad gr5* gr6*
 ;

 gr5
 :
 	cta com*
 ;

 gr6
 :
 	rff dtm*
 ;

 gr7
 :
 	tcc cux? pri? eqn? pcd? moa* qty* loc*
 ;

 gr8
 :
 	icd dtm? ftx*
 ;

 gr9
 :
 	tdt dtm* gr10* gr11* sel* ftx* gr12* gr13* gr14* gr15* gr16* gr17* gr18*
 ;

 gr10
 :
 	tsr scc*
 ;

 gr11
 :
 	loc dtm*
 ;

 gr12
 :
 	mea eqn?
 ;

 gr13
 :
 	dim eqn?
 ;

 gr14
 :
 	cta com*
 ;

 gr15
 :
 	tcc moa* pcd?
 ;

 gr16
 :
 	icd dtm? ftx*
 ;

 gr17
 :
 	rff dtm*
 ;

 gr18
 :
 	nad loc* gr19* gr20* gr21* gr22*
 ;

 gr19
 :
 	cta com*
 ;

 gr20
 :
 	doc dtm?
 ;

 gr21
 :
 	tcc cux? pri? eqn? pcd? moa* qty*
 ;

 gr22
 :
 	rff dtm*
 ;

 gr23
 :
 	eqd eqn? tpl? tmd? mea* dim* sel* nad* loc* han? tmp? ftx* rff* pcd* gr24*
 	gr25* gr26*
 ;

 gr24
 :
 	eqa eqn?
 ;

 gr25
 :
 	dgs ftx*
 ;

 gr26
 :
 	cta com*
 ;

 gr27
 :
 	cni gr28* gr30* cta? com* dtm* cnt* tsr* cux* pcd* moa* ftx* gds* gr32*
 	gr33* gr34* gr35* gr37* gr38* gr39* gr40* gr46* gr53* gr73*
 ;

 gr28
 :
 	sgp gr29*
 ;

 gr29
 :
 	mea eqn?
 ;

 gr30
 :
 	tpl gr31*
 ;

 gr31
 :
 	mea eqn?
 ;

 gr32
 :
 	loc dtm*
 ;

 gr33
 :
 	tod loc*
 ;

 gr34
 :
 	rff dtm*
 ;

 gr35
 :
 	gor dtm* loc* sel* ftx* gr36*
 ;

 gr36
 :
 	doc dtm?
 ;

 gr37
 :
 	cpi rff* cux? loc* moa*
 ;

 gr38
 :
 	tcc loc? ftx? cux? pri? eqn? pcd? moa* qty*
 ;

 gr39
 :
 	icd dtm? ftx*
 ;

 gr40
 :
 	tdt dtm* gr41* gr42* gr43* gr44* gr45*
 ;

 gr41
 :
 	tsr scc*
 ;

 gr42
 :
 	loc dtm*
 ;

 gr43
 :
 	rff dtm?
 ;

 gr44
 :
 	tcc moa* pcd?
 ;

 gr45
 :
 	icd dtm? ftx*
 ;

 gr46
 :
 	nad loc* moa* gr47* gr48* gr49* gr50* gr51* gr52*
 ;

 gr47
 :
 	cta com*
 ;

 gr48
 :
 	doc dtm?
 ;

 gr49
 :
 	tcc cux? pri? eqn? pcd? moa* qty*
 ;

 gr50
 :
 	rff dtm*
 ;

 gr51
 :
 	cpi rff* cux? loc* moa*
 ;

 gr52
 :
 	tsr rff? loc? tpl? ftx*
 ;

 gr53
 :
 	gid han? tmp? rng? tmd? loc* moa* pia* gin* ftx* gr54* gr55* gr56* gr57*
 	gr58* gr59* gr60* gr62* gr64* gr66* gr67*
 ;

 gr54
 :
 	nad dtm? gds*
 ;

 gr55
 :
 	mea eqn?
 ;

 gr56
 :
 	dim eqn?
 ;

 gr57
 :
 	rff dtm*
 ;

 gr58
 :
 	pci rff? dtm? gin* mea* dim? ftx*
 ;

 gr59
 :
 	doc dtm*
 ;

 gr60
 :
 	gor dtm* loc* sel* ftx* gr61*
 ;

 gr61
 :
 	doc dtm?
 ;

 gr62
 :
 	tpl gr63*
 ;

 gr63
 :
 	mea eqn?
 ;

 gr64
 :
 	sgp seq? gr65*
 ;

 gr65
 :
 	mea eqn?
 ;

 gr66
 :
 	tcc cux? pri? eqn? pcd? moa* qty* loc*
 ;

 gr67
 :
 	icd dtm? ftx*
 ;

 gr68
 :
 	dgs ftx* gr69* gr70* gr71*
 ;

 gr69
 :
 	cta com*
 ;

 gr70
 :
 	mea eqn?
 ;

 gr71
 :
 	sgp gr72*
 ;

 gr72
 :
 	mea eqn?
 ;

 gr73
 :
 	eqd eqn? tmd? mea* dim* sel* tpl* han? tmp? ftx* pcd* gr74* gr75* gr76*
 	gr77*
 ;

 gr74
 :
 	tcc cux? pri? eqn? pcd? moa* qty*
 ;

 gr75
 :
 	nad dtm?
 ;

 gr76
 :
 	eqa eqn?
 ;

 gr77
 :
 	dgs ftx* gr78*
 ;

 gr78
 :
 	cta com*
 ;
