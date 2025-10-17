package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties", "classpath:main.properties"})
public interface MainConfig extends Config {
    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}
