package com.crio.shorturl;

import java.util.HashMap;
import java.util.Map;

public class XUrlImpl implements XUrl{

    //longUrlToShortUrl
    private Map<String, String> longToShort;
    //shortUrlToLongUrl
    private Map<String, String> shortToLong;
    //hitcount
    private Map<String, Integer> hitCount;

    public XUrlImpl(){
        this.longToShort = new HashMap<>();
        this.shortToLong = new HashMap<>();
        this.hitCount = new HashMap<>();
    }


    @Override
    public String registerNewUrl(String longUrl) {
        if(!longToShort.containsKey(longUrl)){
            String shortUrl = "http://short.url/";
            
            shortUrl += RandomGenerator.generate();

            return registerNewUrl(longUrl, shortUrl);
        }

        return longToShort.get(longUrl);
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl) {
        if(shortToLong.containsKey(shortUrl))
            return null;
        
        longToShort.put(longUrl, shortUrl);

        //reverseMapping
        shortToLong.put(shortUrl, longUrl);

        //update hitcount
        hitCount.put(longUrl, 0);

        return shortUrl;
    }

    @Override
    public String getUrl(String shortUrl) {
        if(shortToLong.containsKey(shortUrl)){
            String longUrl = shortToLong.get(shortUrl);
            hitCount.put(longUrl, hitCount.getOrDefault(longUrl, 0) + 1);

            return longUrl;
        }

        return null;
    }

    @Override
    public Integer getHitCount(String longUrl) {
        return hitCount.containsKey(longUrl) ? hitCount.get(longUrl) : 0;
    }

    @Override
    public String delete(String longUrl) {
        String shortUrl = longToShort.get(longUrl);
        
        longToShort.remove(longUrl);
        shortToLong.remove(shortUrl);

        return longUrl;
    }
}