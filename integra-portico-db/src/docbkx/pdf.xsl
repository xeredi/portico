<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xslthl="http://xslthl.sf.net"
    xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="xslthl" version="1.0">
    <xsl:import href="urn:docbkx:stylesheet" />
    <xsl:import href="urn:docbkx:stylesheet/highlight.xsl" />

    <xsl:param name="paper.type" select="'A4'" />

    <xsl:param name="alignment">
        justify
    </xsl:param>

    <xsl:param name="double.sided">
        0
    </xsl:param>
    <xsl:param name="headers.on.blank.pages">
        0
    </xsl:param>
    <xsl:param name="footers.on.blank.pages">
        0
    </xsl:param>

    <xsl:param name="page.margin.top">
        5mm
    </xsl:param>
    <xsl:param name="region.before.extent">
        10mm
    </xsl:param>
    <xsl:param name="body.margin.top">
        10mm
    </xsl:param>

    <xsl:param name="body.margin.bottom">
        15mm
    </xsl:param>
    <xsl:param name="region.after.extent">
        10mm
    </xsl:param>
    <xsl:param name="page.margin.bottom">
        5mm
    </xsl:param>

    <xsl:param name="page.margin.outer">
        10mm
    </xsl:param>
    <xsl:param name="page.margin.inner">
        10mm
    </xsl:param>

    <!-- No intendation of Titles -->
    <xsl:param name="title.margin.left">
        0
    </xsl:param>
    <xsl:param name="body.font.size">
        8
    </xsl:param>
    <xsl:param name="body.font.master">
        8
    </xsl:param>
    <xsl:param name="body.start.indent">
        0
    </xsl:param>
</xsl:stylesheet>