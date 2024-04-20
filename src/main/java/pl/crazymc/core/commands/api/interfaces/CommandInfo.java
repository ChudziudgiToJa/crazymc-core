package pl.crazymc.core.commands.api.interfaces;

import java.lang.annotation.*;

@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandInfo {

    String name() default "";

    boolean player() default false;

    String usage() default "";

    String perm() default "";

    String[] aliases() default "";

}
