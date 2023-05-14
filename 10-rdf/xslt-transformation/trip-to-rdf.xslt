<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:S="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:ns2="http://trip_planner.example.org/"
    xmlns:ex="http://example.org/vocabulary/"
    xmlns:gr="http://purl.org/goodrelations/v1#"
    xmlns:geo="http://www.w3.org/2003/01/geo/wgs84_pos#"
    xmlns:tl="http://purl.org/NET/c4dm/timeline.owl#"
    xmlns:country="http://eulersharp.sourceforge.net/2003/03swap/countries#"
    exclude-result-prefixes="S ns2">
    <xsl:output method="text"/>
<xsl:template match="/">@prefix ex: &lt;http://example.org/vocabulary/&gt; .
@prefix xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt; .
@prefix trip: &lt;http://example.org/trips/&gt; .
@prefix acm: &lt;http://example.org/accommodation/&gt; .
@prefix geo: &lt;http://www.w3.org/2003/01/geo/wgs84_pos#&gt; .
@prefix tl: &lt;http://purl.org/NET/c4dm/timeline.owl#&gt; .
@prefix gr: &lt;http://purl.org/goodrelations/v1#&gt; .
@prefix country: &lt;http://eulersharp.sourceforge.net/2003/03swap/countries#&gt; .
   <xsl:apply-templates select="//ns2:getOrCreateResponse/return"/>
 </xsl:template>

 <xsl:template match="return">
<xsl:variable name="tripUuid" select="uuid"/>
<xsl:variable name="address" select="accommodation/address"/>
<xsl:variable name="accommodationIri" select="concat('acm:', $tripUuid)"/>
trip:<xsl:value-of select="uuid" /> a ex:Trip ;
    ex:uuid "<xsl:value-of select="uuid" />" ;
    gr:name "<xsl:value-of select="name" />"@en ;
    tl:start "<xsl:value-of select="dateFrom" />"^^xsd:dateTime ;
    tl:duration "<xsl:value-of select="duration" />" ;
    ex:tripCityName "<xsl:value-of select="locationCity" />"@en ;
    ex:tripCountryName "<xsl:value-of select="locationCountry" />"@en ;
    geo:lat <xsl:value-of select="latitude" /> ;
    geo:long <xsl:value-of select="longitude" /> ;
    ex:associatedWith <xsl:value-of select="$accommodationIri" /> .

<xsl:value-of select="$accommodationIri" /> a ex:Accommodation ;
    gr:name "<xsl:value-of select="accommodation/name" />"@en ;
    ex:isBooked <xsl:value-of select="accommodation/isBooked" /> ;
    ex:hasAddress [
        ex:streetAddress "<xsl:value-of select="$address/streetAddress" />"@en ;
        ex:cityName "<xsl:value-of select="$address/city" />"@en ;
        ex:postalCode "<xsl:value-of select="$address/postalCode" />" ;
        ex:country country:<xsl:value-of select="$address/countryCode" /> ;
    ] .
</xsl:template>
</xsl:stylesheet>
