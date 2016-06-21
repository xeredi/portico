SET DEFINE OFF;
Insert into LQ_ASPECTO_PREFORMATO
   (IDPREFORMATO, NUMCAMFIJOS, NUMCOLDETALLE, XMLPREFORMATO)
 Values
   ('General 2LHI 9Col', 5, 9, '<?xml version="1.0" encoding="UTF-8"  ?>
<!-- Created with iReport - A designer for JasperReports -->
<!DOCTYPE jasperReport PUBLIC "//JasperReports//DTD Report Design//EN" "http://jasperreports.sourceforge.net/dtds/jasperreport.dtd">
<jasperReport
		 name="Informe genérico 3L 9C Azul (b39)"
		 columnCount="1"
		 printOrder="Vertical"
		 orientation="Landscape"
		 pageWidth="842"
		 pageHeight="595"
		 columnWidth="786"
		 columnSpacing="0"
		 leftMargin="28"
		 rightMargin="28"
		 topMargin="28"
		 bottomMargin="14"
		 whenNoDataType="AllSectionsNoDetail"
		 isTitleNewPage="false"
		 isSummaryNewPage="false">
	<property name="ireport.scriptlethandling" value="0" />
	<property name="ireport.encoding" value="UTF-8" />
	<import value="java.util.*" />
	<import value="net.sf.jasperreports.engine.*" />
	<import value="net.sf.jasperreports.engine.data.*" />

	<style 
		name="Gris"
		isDefault="false"
		forecolor="#000000"
	>
	</style>

	<parameter name="PATH_IMG" isForPrompting="false" class="java.lang.String"/>
	<parameter name="NUM_LINEAS" isForPrompting="false" class="java.lang.Integer"/>
	<parameter name="PAGINADE" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_COPIA" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_PRIVACY" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_FILIGRANA" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_FIRMA_1" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_FIRMA_2" isForPrompting="false" class="java.lang.String"/>
	<parameter name="IMG_FIRMA_2" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_DATOSPUERTO" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_CONTINUA" isForPrompting="false" class="java.lang.String"/>
	<parameter name="IMG_FIRMA_1" isForPrompting="false" class="java.lang.String"/>
	<parameter name="ETIQUETA_FIRMAS_ALT" isForPrompting="false" class="java.lang.String"/>
	<parameter name="MOSTRAR_IMPORTES_TOTALES" isForPrompting="false" class="java.lang.String"/>

	<field name="isUltimaPage" class="java.lang.Boolean"/>
	<field name="CAB_TITULO" class="java.lang.String"/>
	<field name="CAB_L_TITULO" class="java.lang.String"/>
	<field name="CAB_L_BL1_TITULO" class="java.lang.String"/>
	<field name="CAB_L_BL1_CAMPO1" class="java.lang.String"/>
	<field name="CAB_L_BL1_CAMPO2" class="java.lang.String"/>
	<field name="CAB_L_BL1_CAMPO3" class="java.lang.String"/>
	<field name="CAB_L_BL1_CAMPO4" class="java.lang.String"/>
	<field name="CAB_L_BL2_TITULO" class="java.lang.String"/>
	<field name="CAB_L_BL2_CAMPO4" class="java.lang.String"/>
	<field name="CAB_L_BL2_CAMPO5" class="java.lang.String"/>
	<field name="CAB_L_BL3_TITULO" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO1" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO2" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO3" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO4" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO5" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO6" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO7" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO8" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO9" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO10" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO6++10" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO7++10" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO8++10" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO9++10" class="java.lang.String"/>
	<field name="CAB_L_BL3_CAMPO_OBS" class="java.lang.String"/>
	<field name="CAB_L_BL4_TITULO" class="java.lang.String"/>
	<field name="CAB_L_BL5_IMPBASE" class="java.lang.String"/>
	<field name="CAB_L_BL5_IMPIVA" class="java.lang.String"/>
	<field name="CAB_L_BL5_IMPTOTAL" class="java.lang.String"/>
	<field name="CAB_BL1_TITULO" class="java.lang.String"/>
	<field name="CAB_BL1_CAMPO1" class="java.lang.String"/>
	<field name="CAB_BL1_CAMPO2" class="java.lang.String"/>
	<field name="CAB_BL1_CAMPO3" class="java.lang.String"/>
	<field name="CAB_BL1_CAMPO4" class="java.lang.String"/>
	<field name="CAB_BL2_TITULO" class="java.lang.String"/>
	<field name="CAB_BL2_CAMPO1" class="java.lang.String"/>
	<field name="CAB_BL2_CAMPO2" class="java.lang.String"/>
	<field name="CAB_BL2_CAMPO3" class="java.lang.String"/>
	<field name="CAB_BL2_CAMPO4" class="java.lang.String"/>
	<field name="CAB_BL2_CAMPO5" class="java.lang.String"/>
	<field name="CAB_BL3_TITULO" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO1" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO2" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO3" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO4" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO5" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO7" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO6" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO8" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO9" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO10" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO6++10" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO7++10" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO8++10" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO9++10" class="java.lang.String"/>
	<field name="CAB_BL3_CAMPO_OBS" class="java.lang.String"/>
	<field name="CAB_BL5_IMPBASE" class="java.lang.String"/>
	<field name="CAB_BL5_IMPIVA" class="java.lang.String"/>
	<field name="CAB_BL5_IMPTOTAL" class="java.lang.String"/>
	<field name="CAB_BL6_FOOTER" class="java.lang.String"/>
	<field name="CAB_BL5_PORCENTIVA" class="java.lang.String"/>
	<field name="CAB_BL5_IMPBASEIVA" class="java.lang.String"/>
	<field name="CAB_BL4_TITULO" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA1" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA2" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA3" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA4" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA1+2" class="java.lang.String"/>
	<field name="HED_L_BL4_COL1+2+3" class="java.lang.String"/>
	<field name="HED_L_BL4_COL1+2+3+4" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA3+4" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA5" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA6" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA7" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA8" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA7+8" class="java.lang.String"/>
	<field name="HED_L_BL4_COLUMNA9" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA1" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA2" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA3" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA4" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA1+2" class="java.lang.String"/>
	<field name="LIN_BL4_COL1+2+3" class="java.lang.String"/>
	<field name="LIN_BL4_COL1+2+3+4" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA3+4" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA5" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA6" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA7" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA8" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA7+8" class="java.lang.String"/>
	<field name="LIN_BL4_COLUMNA9" class="java.lang.String"/>

	<variable name="ULTIMA_PAGINA" class="java.lang.Boolean" resetType="Report" incrementType="Page" calculation="Nothing">
		<variableExpression><![CDATA[$F{isUltimaPage}]]></variableExpression>
	</variable>
	<variable name="NO_ULTIMA_PAGINA" class="java.lang.Boolean" resetType="Report" incrementType="Page" calculation="Nothing">
		<variableExpression><![CDATA[new java.lang.Boolean(!$F{isUltimaPage}.booleanValue())]]></variableExpression>
	</variable>
	<variable name="HAYFIRMA2" class="java.lang.Boolean" resetType="Report" calculation="Nothing">
		<variableExpression><![CDATA[new java.lang.Boolean($P{IMG_FIRMA_2}!=null)]]></variableExpression>
	</variable>
	<variable name="HAYFIRMA1" class="java.lang.Boolean" resetType="Report" calculation="Nothing">
		<variableExpression><![CDATA[new java.lang.Boolean($P{IMG_FIRMA_1}!=null)]]></variableExpression>
	</variable>
	<variable name="IMPRIMIR_TOTALES" class="java.lang.Boolean" resetType="Report" incrementType="Page" calculation="Nothing">
		<variableExpression><![CDATA[new java.lang.Boolean(($P{MOSTRAR_IMPORTES_TOTALES}==null || "true".equals($P{MOSTRAR_IMPORTES_TOTALES})) && $V{ULTIMA_PAGINA}.booleanValue())]]></variableExpression>
	</variable>

		<group  name="0" isReprintHeaderOnEachPage="true" >
			<groupExpression><![CDATA[]]></groupExpression>
			<groupHeader>
			<band height="42"  isSplitAllowed="true" >
				<rectangle>
					<reportElement
						mode="Opaque"
						x="0"
						y="19"
						width="786"
						height="22"
						forecolor="#F3FCFF"
						backcolor="#F3FCFF"
						key="rectangle-5"/>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="0"
						width="743"
						height="20"
						key="textField-7"/>
					<box>					<pen lineWidth="0.0" lineStyle="Solid"/>
					<topPen lineWidth="0.0" lineStyle="Solid"/>
					<leftPen lineWidth="0.0" lineStyle="Solid"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid"/>
					<rightPen lineWidth="0.0" lineStyle="Solid"/>
</box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-BoldItalic.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL4_TITULO}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="19"
						width="226"
						height="22"
						key="cabLin1"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isUnderline="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="19"
						width="298"
						height="22"
						key="cabLin1+2"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isUnderline="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA1+2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="19"
						width="363"
						height="22"
						key="cabLin1+2+3"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isUnderline="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COL1+2+3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="19"
						width="434"
						height="22"
						key="cabLin1+2+3+4"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isUnderline="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COL1+2+3+4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="226"
						y="19"
						width="72"
						height="22"
						key="cabLin2"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="298"
						y="19"
						width="65"
						height="22"
						key="cabLin3"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="298"
						y="19"
						width="136"
						height="22"
						key="cabLin3+4"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA3+4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="363"
						y="19"
						width="71"
						height="22"
						key="cabLin4"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="434"
						y="19"
						width="70"
						height="22"
						key="cabLin5"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA5}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="504"
						y="19"
						width="70"
						height="22"
						key="cabLin6"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA6}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="574"
						y="19"
						width="70"
						height="22"
						key="cabLin7"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA7}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="574"
						y="19"
						width="140"
						height="22"
						key="cabLin7+8"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA7+8}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="644"
						y="19"
						width="70"
						height="22"
						key="cabLin8"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA8}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="714"
						y="19"
						width="72"
						height="22"
						key="cabLin9"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isItalic="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{HED_L_BL4_COLUMNA9}]]></textFieldExpression>
				</textField>
			</band>
			</groupHeader>
			<groupFooter>
			<band height="0"  isSplitAllowed="true" >
			</band>
			</groupFooter>
		</group>
		<group  name="A" >
			<groupExpression><![CDATA[]]></groupExpression>
			<groupHeader>
			<band height="0"  isSplitAllowed="true" >
			</band>
			</groupHeader>
			<groupFooter>
			<band height="0"  isSplitAllowed="true" >
			</band>
			</groupFooter>
		</group>
		<background>
			<band height="0"  isSplitAllowed="false" >
			</band>
		</background>
		<title>
			<band height="0"  isSplitAllowed="false" >
			</band>
		</title>
		<pageHeader>
			<band height="187"  isSplitAllowed="true" >
				<image  hAlign="Right" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="635"
						y="-13"
						width="150"
						height="74"
						key="image-1"/>
					<box></box>
					<graphicElement stretchType="NoStretch"/>
					<imageExpression class="java.lang.String"><![CDATA[$P{PATH_IMG} +  "/logoPuertoFacturaGrande.png"]]></imageExpression>
				</image>
				<image  scaleImage="FillFrame" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						mode="Transparent"
						x="0"
						y="0"
						width="600"
						height="20"
						key="image-2"/>
					<box></box>
					<graphicElement stretchType="NoStretch"/>
					<imageExpression class="java.lang.String"><![CDATA[$P{PATH_IMG} +  "/fondo_banner_600x20_azul.png"]]></imageExpression>
				</image>
				<rectangle>
					<reportElement
						mode="Opaque"
						x="95"
						y="74"
						width="158"
						height="44"
						forecolor="#F3FCFF"
						backcolor="#F3FCFF"
						key="rectangle-1"/>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<rectangle>
					<reportElement
						mode="Opaque"
						x="260"
						y="74"
						width="340"
						height="44"
						forecolor="#F3FCFF"
						backcolor="#F3FCFF"
						key="rectangle-2"/>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<rectangle>
					<reportElement
						mode="Opaque"
						x="0"
						y="137"
						width="786"
						height="22"
						forecolor="#F3FCFF"
						backcolor="#F3FCFF"
						key="rectangle-3"/>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<rectangle>
					<reportElement
						mode="Opaque"
						x="0"
						y="74"
						width="92"
						height="44"
						forecolor="#C8E1F3"
						backcolor="#C8E1F3"
						key="rectangle-12"/>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<rectangle>
					<reportElement
						mode="Opaque"
						x="0"
						y="164"
						width="786"
						height="22"
						forecolor="#F3FCFF"
						backcolor="#F3FCFF"
						key="rectangle-11"/>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="2"
						y="27"
						width="153"
						height="25"
						key="textField-1"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="SansSerif" pdfFontName="Roboto-Bold.ttf" size="12" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_TITULO}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="136"
						y="27"
						width="433"
						height="31"
						key="textField-2"/>
					<box></box>
					<textElement isStyledText="true">
						<font pdfFontName="Roboto-Medium.ttf" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_TITULO}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="58"
						width="225"
						height="17"
						key="textField-3"/>
					<box></box>
					<textElement isStyledText="true">
						<font pdfFontName="Roboto-BoldItalic.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL1_TITULO}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="260"
						y="58"
						width="320"
						height="17"
						key="textField-4"/>
					<box></box>
					<textElement isStyledText="true">
						<font pdfFontName="Roboto-BoldItalic.ttf" size="9" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL2_TITULO}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="121"
						width="381"
						height="17"
						key="textField-5"/>
					<box></box>
					<textElement isStyledText="true">
						<font pdfFontName="Roboto-BoldItalic.ttf" size="9" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_TITULO}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="2"
						y="138"
						width="216"
						height="11"
						key="textField-44"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="220"
						y="138"
						width="132"
						height="11"
						key="textField-45"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="220"
						y="148"
						width="132"
						height="11"
						key="textField-48"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="2"
						y="148"
						width="216"
						height="11"
						key="textField-49"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="2"
						y="85"
						width="87"
						height="11"
						key="textField-54"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL1_CAMPO1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="2"
						y="97"
						width="87"
						height="11"
						key="textField-55"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Medium.ttf" size="9" isBold="false" isUnderline="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL1_CAMPO1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="152"
						y="85"
						width="55"
						height="11"
						key="textField-56"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL1_CAMPO3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="dd/MM/yyyy" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="152"
						y="97"
						width="55"
						height="11"
						key="textField-57"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL1_CAMPO3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="97"
						y="85"
						width="55"
						height="11"
						key="textField-58"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL1_CAMPO2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="97"
						y="97"
						width="55"
						height="11"
						key="textField-59"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL1_CAMPO2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="207"
						y="85"
						width="45"
						height="11"
						key="textField-60"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL1_CAMPO4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="207"
						y="97"
						width="45"
						height="11"
						key="textField-61"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL1_CAMPO4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="261"
						y="68"
						width="248"
						height="20"
						key="textField-62"/>
					<box>					<pen lineWidth="0.0" lineStyle="Solid"/>
					<topPen lineWidth="0.0" lineStyle="Solid"/>
					<leftPen lineWidth="0.0" lineStyle="Solid"/>
					<bottomPen lineWidth="0.0" lineStyle="Solid"/>
					<rightPen lineWidth="0.0" lineStyle="Solid"/>
</box>
					<textElement verticalAlignment="Bottom" isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL2_CAMPO1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="261"
						y="86"
						width="248"
						height="20"
						key="textField-63"/>
					<box></box>
					<textElement verticalAlignment="Middle" isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL2_CAMPO2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="261"
						y="104"
						width="248"
						height="20"
						key="textField-64"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL2_CAMPO3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="560"
						y="79"
						width="36"
						height="11"
						key="textField-65"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL2_CAMPO5}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="510"
						y="79"
						width="50"
						height="11"
						key="textField-66"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL2_CAMPO4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="510"
						y="91"
						width="50"
						height="11"
						key="textField-67"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL2_CAMPO4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="560"
						y="91"
						width="36"
						height="11"
						key="textField-68"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL2_CAMPO5}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="352"
						y="148"
						width="132"
						height="11"
						key="textField-75"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="352"
						y="138"
						width="132"
						height="11"
						key="textField-76"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="484"
						y="148"
						width="132"
						height="11"
						key="textField-77"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="484"
						y="138"
						width="132"
						height="11"
						key="textField-78"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="619"
						y="148"
						width="166"
						height="11"
						key="textField-79"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO5}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="619"
						y="138"
						width="166"
						height="11"
						key="textField-80"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO5}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="572"
						y="61"
						width="214"
						height="17"
						key="footerLabel"/>
					<box></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="12" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{ETIQUETA_COPIA}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="646"
						y="81"
						width="140"
						height="50"
						key="textField-85"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{ETIQUETA_DATOSPUERTO}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="2"
						y="165"
						width="216"
						height="11"
						key="textField-86"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO6}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="220"
						y="165"
						width="132"
						height="11"
						key="textField-87"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO7}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="220"
						y="175"
						width="132"
						height="11"
						key="textField-88"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO7}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="2"
						y="175"
						width="216"
						height="11"
						key="textField-89"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO6}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="352"
						y="175"
						width="132"
						height="11"
						key="textField-90"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO8}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="352"
						y="165"
						width="132"
						height="11"
						key="textField-91"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO8}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="484"
						y="175"
						width="132"
						height="11"
						key="textField-92"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO9}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="484"
						y="165"
						width="132"
						height="11"
						key="textField-93"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO9}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="619"
						y="175"
						width="166"
						height="11"
						key="textField-94"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="619"
						y="165"
						width="166"
						height="11"
						key="textField-95"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="2"
						y="165"
						width="783"
						height="11"
						key="textField-112"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO6++10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="2"
						y="175"
						width="783"
						height="11"
						key="textField-113"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO6++10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="220"
						y="175"
						width="565"
						height="11"
						key="textField-114"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO7++10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="220"
						y="165"
						width="565"
						height="11"
						key="textField-115"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO7++10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="352"
						y="175"
						width="433"
						height="11"
						key="textField-116"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO8++10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="352"
						y="165"
						width="433"
						height="11"
						key="textField-117"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO8++10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="484"
						y="175"
						width="301"
						height="11"
						key="textField-118"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO9++10}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="484"
						y="165"
						width="301"
						height="11"
						key="textField-119"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO9++10}]]></textFieldExpression>
				</textField>
			</band>
		</pageHeader>
		<columnHeader>
			<band height="26"  isSplitAllowed="true" >
				<printWhenExpression><![CDATA[new java.lang.Boolean($F{CAB_BL3_CAMPO_OBS}!=null && $F{CAB_BL3_CAMPO_OBS}.trim().length()>0)]]></printWhenExpression>
				<rectangle>
					<reportElement
						mode="Opaque"
						x="0"
						y="4"
						width="786"
						height="22"
						forecolor="#F3FCFF"
						backcolor="#F3FCFF"
						key="rectangle-13"/>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="2"
						y="5"
						width="783"
						height="11"
						key="textField-120"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-MediumItalic.ttf" size="8" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL3_CAMPO_OBS}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="2"
						y="15"
						width="783"
						height="11"
						key="textField-121"/>
					<box></box>
					<textElement isStyledText="true">
						<font fontName="Verdana" pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL3_CAMPO_OBS}]]></textFieldExpression>
				</textField>
			</band>
		</columnHeader>
		<detail>
			<band height="15"  isSplitAllowed="true" >
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="0"
						y="1"
						width="226"
						height="13"
						key="Lin1"
						stretchType="RelativeToBandHeight"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="0"
						y="1"
						width="298"
						height="13"
						key="Lin1+2"
						stretchType="RelativeToBandHeight"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA1+2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="0"
						y="1"
						width="363"
						height="13"
						key="Lin1+2+3"
						stretchType="RelativeToBandHeight"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COL1+2+3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="0"
						y="1"
						width="434"
						height="13"
						key="Lin1+2+3+4"
						stretchType="RelativeToBandHeight"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COL1+2+3+4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="226"
						y="1"
						width="72"
						height="13"
						key="Lin2"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA2}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="298"
						y="1"
						width="65"
						height="13"
						key="Lin3"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA3}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="298"
						y="1"
						width="136"
						height="13"
						key="Lin3+4"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA3+4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="363"
						y="1"
						width="71"
						height="13"
						key="Lin4"/>
					<box leftPadding="5"></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA4}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="434"
						y="1"
						width="70"
						height="13"
						key="Lin5"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA5}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="504"
						y="1"
						width="70"
						height="13"
						key="Lin6"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA6}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="574"
						y="1"
						width="70"
						height="13"
						key="Lin7"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA7}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="574"
						y="1"
						width="140"
						height="13"
						key="Lin7+8"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA7+8}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="644"
						y="1"
						width="70"
						height="13"
						key="Lin8"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA8}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" pattern="" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						style="Gris"
						x="714"
						y="1"
						width="72"
						height="13"
						key="Lin9"/>
					<box leftPadding="5" rightPadding="5"></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{LIN_BL4_COLUMNA9}]]></textFieldExpression>
				</textField>
				<line direction="TopDown">
					<reportElement
						x="0"
						y="14"
						width="786"
						height="0"
						key="line-6"
						positionType="Float"/>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Dashed"/>
</graphicElement>
				</line>
			</band>
		</detail>
		<columnFooter>
			<band height="0"  isSplitAllowed="false" >
				<printWhenExpression><![CDATA[$V{NO_ULTIMA_PAGINA}]]></printWhenExpression>
			</band>
		</columnFooter>
		<pageFooter>
			<band height="124"  isSplitAllowed="false" >
				<line direction="TopDown">
					<reportElement
						x="0"
						y="72"
						width="785"
						height="0"
						key="line-1"/>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.5" lineStyle="Solid"/>
</graphicElement>
				</line>
				<textField isStretchWithOverflow="false" pattern="" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						mode="Transparent"
						x="-1"
						y="92"
						width="803"
						height="32"
						key="textField-8"/>
					<box></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="5" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{ETIQUETA_PRIVACY}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="0"
						y="74"
						width="725"
						height="23"
						key="textField-9"/>
					<box></box>
					<textElement isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="7" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL6_FOOTER}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="543"
						y="11"
						width="141"
						height="17"
						key="textField-10">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL5_IMPBASE}]]></textFieldExpression>
				</textField>
				<rectangle>
					<reportElement
						mode="Opaque"
						x="537"
						y="46"
						width="247"
						height="17"
						forecolor="#D4E8F6"
						backcolor="#D4E8F6"
						key="rectangle-10">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch"/>
				</rectangle>
				<textField isStretchWithOverflow="true" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="543"
						y="28"
						width="28"
						height="17"
						key="textField-11">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL5_IMPIVA}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="543"
						y="45"
						width="155"
						height="17"
						key="textField-12">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Medium.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_L_BL5_IMPTOTAL}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="693"
						y="11"
						width="90"
						height="17"
						key="textField-13">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="9" isBold="false" isPdfEmbedded ="true" pdfEncoding ="Cp1250"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL5_IMPBASE}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="693"
						y="28"
						width="90"
						height="17"
						key="textField-14">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="9" isBold="false" isPdfEmbedded ="true" pdfEncoding ="Cp1250"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL5_IMPIVA}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="693"
						y="45"
						width="90"
						height="17"
						key="textField-15">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Medium.ttf" size="9" isBold="false" isPdfEmbedded ="true" pdfEncoding ="Cp1250"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL5_IMPTOTAL}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="true" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="570"
						y="28"
						width="41"
						height="17"
						key="textField-16">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL5_PORCENTIVA}]]></textFieldExpression>
				</textField>
				<line direction="TopDown">
					<reportElement
						x="537"
						y="27"
						width="248"
						height="0"
						key="line-2">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Solid"/>
</graphicElement>
				</line>
				<line direction="TopDown">
					<reportElement
						x="537"
						y="11"
						width="248"
						height="0"
						key="line-3">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Solid"/>
</graphicElement>
				</line>
				<line direction="TopDown">
					<reportElement
						x="537"
						y="45"
						width="248"
						height="0"
						key="line-4">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.5" lineStyle="Solid"/>
</graphicElement>
				</line>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="725"
						y="78"
						width="25"
						height="14"
						key="nCurPag"/>
					<box></box>
					<textElement textAlignment="Right">
						<font pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.Integer"><![CDATA[$V{PAGE_NUMBER}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Report" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="761"
						y="78"
						width="25"
						height="14"
						key="nTotPag"/>
					<box></box>
					<textElement textAlignment="Left">
						<font pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.Integer"><![CDATA[$V{PAGE_NUMBER}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="750"
						y="78"
						width="11"
						height="14"
						key="textField-71"/>
					<box></box>
					<textElement textAlignment="Center">
						<font pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{PAGINADE}]]></textFieldExpression>
				</textField>
				<line direction="TopDown">
					<reportElement
						x="565"
						y="30"
						width="0"
						height="13"
						forecolor="#FFFFFF"
						backcolor="#FFFFFF"
						key="line-7">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Solid"/>
</graphicElement>
				</line>
				<line direction="TopDown">
					<reportElement
						x="694"
						y="30"
						width="0"
						height="13"
						forecolor="#FFFFFF"
						backcolor="#FFFFFF"
						key="line-8">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Solid"/>
</graphicElement>
				</line>
				<line direction="TopDown">
					<reportElement
						mode="Opaque"
						x="694"
						y="48"
						width="0"
						height="13"
						forecolor="#FFE9FD"
						backcolor="#FFE9FD"
						key="line-9">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Solid"/>
</graphicElement>
				</line>
				<line direction="TopDown">
					<reportElement
						x="694"
						y="13"
						width="0"
						height="13"
						forecolor="#FFFFFF"
						backcolor="#FFFFFF"
						key="line-10">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Solid"/>
</graphicElement>
				</line>
				<line direction="TopDown">
					<reportElement
						x="610"
						y="30"
						width="0"
						height="13"
						forecolor="#FFFFFF"
						backcolor="#FFFFFF"
						key="line-11">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<graphicElement stretchType="NoStretch">
					<pen lineWidth="0.25" lineStyle="Solid"/>
</graphicElement>
				</line>
				<textField isStretchWithOverflow="true" isBlankWhenNull="true" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="603"
						y="28"
						width="90"
						height="17"
						key="textField-73">
							<printWhenExpression><![CDATA[$V{IMPRIMIR_TOTALES}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<textElement textAlignment="Right" verticalAlignment="Middle" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="9" isBold="false" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$F{CAB_BL5_IMPBASEIVA}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" pattern="#,##0.00" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="749"
						y="-2"
						width="32"
						height="13"
						key="textField-74"
						isRemoveLineWhenBlank="true"/>
					<box></box>
					<textElement textAlignment="Right" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[($V{ULTIMA_PAGINA}.booleanValue()) ? "" : $P{ETIQUETA_CONTINUA}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="-17"
						y="-425"
						width="10"
						height="488"
						key="textField-83"
						positionType="FixRelativeToBottom"/>
					<box></box>
					<textElement textAlignment="Center" rotation="Left">
						<font pdfFontName="Roboto-Light.ttf" size="6" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{ETIQUETA_FILIGRANA}]]></textFieldExpression>
				</textField>
				<image  evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="39"
						y="12"
						width="161"
						height="59"
						key="image-3">
							<printWhenExpression><![CDATA[$V{HAYFIRMA1}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<graphicElement stretchType="NoStretch"/>
					<imageExpression class="java.lang.String"><![CDATA[$P{PATH_IMG}+"/"+$P{IMG_FIRMA_1}]]></imageExpression>
				</image>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						mode="Opaque"
						x="-4"
						y="1"
						width="217"
						height="11"
						key="textField-84"/>
					<box></box>
					<textElement textAlignment="Center" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{ETIQUETA_FIRMA_1}]]></textFieldExpression>
				</textField>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						mode="Transparent"
						x="198"
						y="1"
						width="217"
						height="11"
						key="textField-110"/>
					<box></box>
					<textElement textAlignment="Center" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{ETIQUETA_FIRMA_2}]]></textFieldExpression>
				</textField>
				<image  onErrorType="Blank" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						x="240"
						y="12"
						width="161"
						height="59"
						key="image-4">
							<printWhenExpression><![CDATA[$V{HAYFIRMA2}]]></printWhenExpression>
						</reportElement>
					<box></box>
					<graphicElement stretchType="NoStretch"/>
					<imageExpression class="java.lang.String"><![CDATA[$P{PATH_IMG}+"/"+$P{IMG_FIRMA_2}]]></imageExpression>
				</image>
				<textField isStretchWithOverflow="false" isBlankWhenNull="false" evaluationTime="Now" hyperlinkType="None"  hyperlinkTarget="Self" >
					<reportElement
						mode="Transparent"
						x="0"
						y="43"
						width="537"
						height="29"
						key="textField-111"/>
					<box></box>
					<textElement textAlignment="Left" isStyledText="true">
						<font pdfFontName="Roboto-Light.ttf" size="8" isPdfEmbedded ="true"/>
					</textElement>
				<textFieldExpression   class="java.lang.String"><![CDATA[$P{ETIQUETA_FIRMAS_ALT}]]></textFieldExpression>
				</textField>
			</band>
		</pageFooter>
		<summary>
			<band height="0"  isSplitAllowed="false" >
			</band>
		</summary>
</jasperReport>
');
COMMIT;
