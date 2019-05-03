package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTest {

  @Test
  public void testMyIp(){
    String ipLocation20 = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("178.19.253.105");
    assertEquals(ipLocation20, "<GeoIP><Country>RU</Country><State>28</State></GeoIP>");
  }
  @Test
  public void testInvalidIp(){
    String ipLocation20 = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("178.19.253.xxx");
    assertEquals(ipLocation20, null);
  }
}
