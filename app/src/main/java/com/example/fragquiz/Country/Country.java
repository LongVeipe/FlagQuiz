package com.example.fragquiz.Country;

public class Country {
    private String CountryCode;
    private String CountryName;
    private String RegionCode;
    private String ImgURL;

    public Country(String countryName, String countryCode, String regionCode, String imgURL) {
        CountryCode = countryCode;
        CountryName = countryName;
        RegionCode = regionCode;
        ImgURL = imgURL;
    }

    public Country() {
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getCountryName() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        CountryName = countryName;
    }

    public String getRegionCode() {
        return RegionCode;
    }

    public void setRegionCode(String regionCode) {
        RegionCode = regionCode;
    }

    public String getImgURL() {
        return ImgURL;
    }

    public void setImgURL(String imgURL) {
        ImgURL = imgURL;
    }
}
