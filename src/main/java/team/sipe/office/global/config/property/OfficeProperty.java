package team.sipe.office.global.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "office")
public class OfficeProperty {
    private Boolean health;

    public OfficeProperty() {
    }

    public OfficeProperty(final Boolean health) {
        this.health = health;
    }

    public Boolean getHealth() {
        return health;
    }

    public void setHealth(final Boolean health) {
        this.health = health;
    }
}
