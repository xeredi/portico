/**
 * D93a
 * 	http://www.unece.org/trade/untdid/d93/
 * 	http://www.unece.org/fileadmin/DAM/trade/untdid/d14b/trmd/ifcsum_c.htm
 * http://content.portdebarcelona.cat/cntmng/d/d/workspace/SpacesStore/2185ccaf-a590-4dba-8a64-74d95cb929b7/GuiaDSDescarga_Carga33b.pdf%7cGuiaDSDescarga_Carga33b.pdf
 */
 grammar Ifcsum;

import edifact_d16b_segments, edifact_d16b_components, edifact_d16b_fields;

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

/* Consignatario Mercancia */
 gr4
 :
 	nad gr5* gr1*
 ;

 gr5
 :
 	cta com*
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
 	tdt dtm* gr10* gr11* sel* ftx* gr12* gr13* gr5* gr15* gr8* gr1* gr18*
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

 gr15
 :
 	tcc moa* pcd?
 ;

 gr18
 :
 	nad loc* gr5* gr3* gr21* gr1*
 ;

 gr21
 :
 	tcc cux? pri? eqn? pcd? moa* qty*
 ;

 gr23
 :
 	eqd eqn? tpl? tmd? mea* dim* sel* nad* loc* han? tmp? ftx* rff* pcd* gr24*
 	gr25* gr5*
 ;

 gr24
 :
 	eqa eqn?
 ;

 gr25
 :
 	dgs ftx*
 ;

/* BL */
 gr27
 :
 	cni gr28* gr30* cta? com* dtm* cnt* tsr* cux* pcd* moa* ftx* gds* gr11*
 	gr33* gr1* gr2* gr37* gr38* gr8* gr40* gr46* gr53* gr73*
 ;

 gr28
 :
 	sgp gr12*
 ;

 gr30
 :
 	tpl gr12*
 ;

 gr33
 :
 	tod loc*
 ;

 gr37
 :
 	cpi rff* cux? loc* moa*
 ;

 gr38
 :
 	tcc loc? ftx? cux? pri? eqn? pcd? moa* qty*
 ;

 gr40
 :
 	tdt dtm* gr10* gr11* gr43* gr44* gr8*
 ;

 gr43
 :
 	rff dtm?
 ;

 gr44
 :
 	tcc moa* pcd?
 ;

 gr46
 :
 	nad loc* moa* gr5* gr3* gr21* gr1* gr37* gr52*
 ;

 gr52
 :
 	tsr rff? loc? tpl? ftx*
 ;

/* Partida */
 gr53
 :
 	gid han? tmp? rng? tmd? loc* moa* pia* gin* ftx* gr54* gr12* gr13* gr1*
 	gr58* gr59* gr2* gr30* gr64* gr7* gr8*
 ;

 gr54
 :
 	nad dtm? gds*
 ;

/* Marcas y etiquetas de partida */
 gr58
 :
 	pci rff? dtm? gin* mea* dim? ftx*
 ;

/* Documentos de la partida */
 gr59
 :
 	doc dtm*
 ;

 gr64
 :
 	sgp seq? gr12*
 ;

 gr68
 :
 	dgs ftx* gr5* gr12* gr28*
 ;

 gr73
 :
 	eqd eqn? tmd? mea* dim* sel* tpl* han? tmp? ftx* pcd* gr21* gr75* gr24*
 	gr77*
 ;

 gr75
 :
 	nad dtm?
 ;

 gr77
 :
 	dgs ftx* gr5*
 ;
