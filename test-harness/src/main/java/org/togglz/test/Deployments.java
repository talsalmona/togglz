package org.togglz.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.DependencyResolvers;
import org.jboss.shrinkwrap.resolver.api.maven.MavenDependencyResolver;

public class Deployments {

    public static WebArchive getBasicWebArchive() {
        return ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addAsLibraries(
                        getTogglzCoreArchive(),
                        getTogglzSerlvetArchive())
                .addAsLibraries(
                        DependencyResolvers.use(MavenDependencyResolver.class)
                                .artifact("org.ocpsoft.logging:logging-api:1.0.1.Final")
                                .resolveAs(JavaArchive.class))
                .addClass(FeatureServlet.class)
                .addClass(UserServlet.class);
    }

    public static JavaArchive getTogglzSerlvetArchive() {
        return ShrinkWrap.create(ExplodedImporter.class, "togglz-servlet.jar")
                .importDirectory("../servlet/target/classes")
                .as(JavaArchive.class);
    }

    public static JavaArchive getTogglzCoreArchive() {
        return ShrinkWrap.create(ExplodedImporter.class, "togglz-core.jar")
                .importDirectory("../core/target/classes")
                .as(JavaArchive.class);
    }

    public static JavaArchive getTogglzSpringArchive() {
        return ShrinkWrap.create(ExplodedImporter.class, "togglz-spring.jar")
                .importDirectory("../spring/target/classes")
                .as(JavaArchive.class);
    }

    public static JavaArchive getTogglzCDIArchive() {
        return ShrinkWrap.create(ExplodedImporter.class, "togglz-cdi.jar")
                .importDirectory("../cdi/target/classes")
                .as(JavaArchive.class);
    }

    public static JavaArchive getTogglzJSFArchive() {
        return ShrinkWrap.create(ExplodedImporter.class, "togglz-jsf.jar")
                .importDirectory("../jsf/target/classes")
                .as(JavaArchive.class);
    }

    public static JavaArchive getTogglzSeamSecurityArchive() {
        return ShrinkWrap.create(ExplodedImporter.class, "togglz-seam-security.jar")
                .importDirectory("../seam-security/target/classes")
                .as(JavaArchive.class);
    }

    public static JavaArchive getTogglzShiroArchive() {
        return ShrinkWrap.create(ExplodedImporter.class, "togglz-shiro.jar")
                .importDirectory("../shiro/target/classes")
                .as(JavaArchive.class);
    }

}
