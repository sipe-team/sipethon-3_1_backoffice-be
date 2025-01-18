package team.sipe.office;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import team.sipe.office.global.config.property.OfficeProperty;

@Component
public class OfficeHealthEventHandler {

    private static final Logger logger = LoggerFactory.getLogger(OfficeHealthEventHandler.class);
    private final OfficeProperty officeProperty;

    public OfficeHealthEventHandler(final OfficeProperty officeProperty) {
        this.officeProperty = officeProperty;
    }

    @PostConstruct
    public void boot() {
        logger.info("Spring Boot Application is running health = {}", officeProperty.getHealth());
    }
}
