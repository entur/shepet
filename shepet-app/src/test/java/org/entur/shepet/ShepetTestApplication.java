/*
 * Licensed under the EUPL, Version 1.2 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 *   https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package org.entur.shepet;


import org.entur.shepet.auth.ShepetSecurityConfig;
import org.rutebanken.sobek.exporter.PublicationDeliveryCreator;
import org.rutebanken.sobek.netex.id.ValidPrefixList;
import org.rutebanken.sobek.time.ExportTimeZone;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * Run integration tests for the rest interface without security
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ComponentScan( basePackageClasses = {PublicationDeliveryCreator.class,
        ValidPrefixList.class,
        ExportTimeZone.class,
        },
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes={ ShepetSecurityConfig.class,
                                                ShepetApplication.class}),
}, basePackages = { "org.entur"})
public class ShepetTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShepetTestApplication.class, args);
    }
}