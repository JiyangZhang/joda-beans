## User guide - Code generation

This part of the user guide provides information on code generation of beans.
See the [main user guide](userguide.html) for a higher level introduction.


## Code generator

It is possible to write a Joda-Bean by hand - they are just normal Java interfaces defining an API for beans.
There are some base classes that assist as well as some standard map-based implementations, notably
[FlexiBean](apidocs/org.joda.beans/org/joda/beans/impl/flexi/FlexiBean.html).
It is more common to use the code generator, however the generator is optional.

A code generated Joda-Bean minimises the amount of code that the developer has to write.
The developer simply creates an outline class and adds the properties (fields).
The code generator then produces all the getters and setters, plus additional helper methods.

Here is an example `UserAccount` class showing the parts that a developer has to write:

```
@BeanDefinition
public final class UserAccount implements Bean {

    /** The user identifier. */
    @PropertyDefinition(validate = "notEmpty")
    private String userId;

    /** The email address. */
    @PropertyDefinition(validate = "notEmpty")
    private String emailAddress;

    /** The number of logins. */
    @PropertyDefinition
    private int numberLogins;

    /** The last login instant. */
    @PropertyDefinition(validate = "notNull")
    private Date lastLogin;
}
```

The code generator will create getters, setters, equals, hashCode, toString, metaBean and properties.
To see the generated code for this class,
[click here](https://github.com/JodaOrg/joda-beans/blob/v1.4/src/test/java/org/joda/beans/gen/UserAccount.java#L34).

Note that the equals, hashCode and toString methods are only generated if they do not exist already.
As such, it is easy to write your own versions of these methods if necessary.


## Using the code generator

The code generator must be invoked before compilation as it generates Java source code.
It cannot operate at runtime, as the getters and setters that are generated must be available for developers
writing the main part of the application.

The code generator operates by creating a portion of the source file marked by "AUTOGENERATED START" and "AUTOGENERATED END" tags
(when first run, if the tags are not present, it will create the block at the end of the file).
The generator only ever changes code within the marked block, apart from imports which it inserts if it determines they are necessary.
Limiting the generation to a fixed part of the file means that developers can customise the rest of the Java file in any
way that is desired, such as adding constructors and methods.

The generator has the following requirements:

* The class must be annotated with [BeanDefinition](apidocs/org.joda.beans/org/joda/beans/gen/BeanDefinition.html)
* The class must directly implement the [Bean](apidocs/org.joda.beans/org/joda/beans/Bean.html) or
[ImmutableBean](apidocs/org.joda.beans/org/joda/beans/ImmutableBean.html) interface.
* The class must be a normal top-level class, nested/inner classes and multiple classes per file are not supported
* Each property field must be annotated with [PropertyDefinition](apidocs/org.joda.beans/org/joda/beans/gen/PropertyDefinition.html)
* Each property field must be be private
* The Javadoc of each property field should normally start with the word "The".

The command line takes the following arguments:

```
  Usage java org.joda.beans.gen.BeanCodeGen [file]
  Options
    -R                process all files recursively, default false
    -indent=tab       use a tab for indenting, default 4 spaces
    -indent=[n]       use n spaces for indenting, default 4
    -prefix=[p]       field prefix of p should be removed, no default
    -eol=[e]          end of line: 'lf'/'crlf'/'cr', default System.lineSeparator
    -generated        add @Generated annotation to generated code
    -config=[f]       config file: 'jdk'/'guava', default guava
    -style=[s]        default bean style: 'light'/'minimal'/'full', default smart
    -verbose=[v]      output logging with verbosity from 0 to 3, default 1
    -nowrite          output messages rather than writing, default is to write
```

The prefix is useful for teams that have a coding standard where fields must be prefixed, such as by an underscore or a letter.
Specifying it to the generator allows that prefix to be stripped before generating the property name.

The eol argument allows for configuring the line separator used to write generated files.

The code generator works by reading the source file and parsing it to memory.
The parser is deliberately simplistic and will reject complex files or unusual code formatting styles.
The generator processes the annotated properties and replaces the auto-generated section of the file in memory.
It then compares the newly generated file with the original and only if they are different is the new file written to the file system.
The generator will make use of property comments and will respect and propagate deprecated annotations.
It is reasonably intelligent - final fields will become read-only properties, most collections and maps are sensibly handled
and booleans generate "is" methods rather than "get" methods. Simple generics are also handled.

The generator must be invoked every time that the source file is changed.
Failure to do so (such as by using an IDE refactoring) could leave the auto-generated block in an invalid state.
Normally the generator will be invoked from the IDE or a build tool, see the
[Maven plugin](https://github.com/JodaOrg/joda-beans-maven-plugin).

The code generator only parses and outputs based on a single source Java file.
It does not require the file to compile and never knows that "String" actually means "java.lang.String".
In other words, the type system in the generator is totally dumb and based solely on the short simple class name.


## Customisation

The generator has a limited set of customisations to the core part of the generation.

One key set of control is provided by [@PropertyDefinition](apidocs/org.joda.beans/org/joda/beans/gen/PropertyDefinition.html).

The style of getter can be controlled using the annotation parameter "get".
In most cases, the default "smart" setting is sufficient:

* "" - do not generate any form of getter
* "smart" - process intelligently, using "is" for `boolean` and "get" for other types
* "private" - process as per "smart" but set scope as private
* "package" - process as per 'smart' but set scope as package/default
* "protected" - process as per "smart" but set scope as protected
* "is" - generates `isXxx()`
* "get" - generates `getXxx()`
* "clone" - generates `getXxx()` with a clone of the field (assumed to be of the correct type)
* "cloneCast" - generates `getXxx()` with a clone of the field with a cast to the property type
* "optional" - generate `getXxx()` returning a Java 8 `Optional` wrapper around the field, where the field
 itself is nullable instead of optional. `OptionalDouble`, `OptionalInt` and `OptionalLong` are also handled
* "optionalGuava" - generate `getXxx()` returning a Guava `Optional` wrapper around the field,
 where the field itself is nullable instead of optional
* "field" - generates direct access to the field, enabling a weird manual getter
* "manual" - a method named `getXxx()` must be manually provided

For example, using the optional wrappers:

```
 @BeanDefinition
 public final class Foo implements Bean {
   @PropertyDefinition(get = "optional")
   private String name;  // regular field that can hold null

   // generated getter as follows:
   public Optional<String> getName() {
     return Optional.ofNullable(name);
   }
 }
```

The style of setter can be controlled using the annotation parameter "set".
In most cases, the default "smart" setting is sufficient:

* "' - do not generate any form of setter
* "smart" - process intelligently - uses "set" unless final, when it will use "setClearAddAll"
 for common list types or "setClearPutAll" for common map types and `FlexiBean`
* "private" - process as per "smart" but set scope as private
* "package" - process as per 'smart' but set scope as package/default
* "protected" - process as per "smart" but set scope as protected
* "set" - generates `setXxx()`
* "setClearAddAll" - generates `setXxx()` using `field.clear()` and `field.addAll(newData)`
* "setClearPutAll" - generates `setXxx()` using `field.clear()` and `field.putAll(newData)`
* "bound" - generates a bound property with {@code PropertyChangeSupport}
* "field" - generates direct access to the field, enabling a weird manual setter
* "manual" - a method named `setXxx()` must be manually provided at package scope or greater
* a pattern, see [Javadoc](apidocs/org.joda.beans/org/joda/beans/gen/PropertyDefinition.html#set--)

For example, to have a private setter:

```
 @BeanDefinition
 public final class Foo implements Bean {
   @PropertyDefinition(set = "private")
   private String name;

   // generated setter as follows:
   private String setName() {
     this.name = name;
   }
 }
```

Note that support for bound properties is very basic. It only handles simple mutable properties.
For more complex cases, it is necessary to write the setter manually.
The PropertyChangeSupport field is generated, but not the methods to add listeners.

Validation can be specified using the annotation parameter "validate":

* "" - do not generate any form of validation
* "notNull" - checks that the value is non-null using `JodaBeanUtils.notNull()` which throws IllegalArgumentException
* "notEmpty' - checks that a string/collection/map is non-null and non-empty using `JodaBeanUtils.notEmpty()`
 which throws IllegalArgumentException
* "{staticMethodName}" - a custom validation method located on this class
* "{className}.{staticMethodName}" - a custom validation method located on any class

```
 @BeanDefinition
 public final class Foo implements Bean {
   @PropertyDefinition(validate = "notNull")
   private String surname;  // generated code will ensure field is non-null
 }
```

The exposed type of the property can be specified using the annotation parameter "type".
For example, if the field is declared as an `ArrayList` but the public type of the getter/setter
should be `List` then that can be achieved.
Simply add the annotation parameter `type = "List<>"` (the generics are inserted during generation).

```
 @BeanDefinition
 public final class Foo implements Bean {
   @PropertyDefinition(type = "List<>")
   private ArrayList<String> names;

   // generated getter as follows:
   public List<String> getNames() { ... }
 }
```

The exposed type of the property in the builder used for immutable beans can be specified using the annotation parameter "builderType".
For example, if the field is declared as an `ImmutableList<Address>` but the public type of the builder methods
should be `List<? extends Address>` then that can be achieved.
Simply add the annotation parameter `builderType = "List<? extends Address>"`.

```
 @BeanDefinition
 public final class Foo implements Bean {
   @PropertyDefinition(builderType = "List<? extends Address>")
   private ImmutableList<Address> addresses;

   // generated getter as follows:
   public ImmutableList<Address> getAddresses() { ... }

   // generated builder method as follows:
   public Builder addresses(List<? extends Address> addresses) { ... }
 }
```

A properties getter and/or setter can be declared to override a superclass.
Simply add the annotation parameter `overrideGet = true` or `overrideSet = true`
and the requisite `@Override` annotation will be placed on the getter/setter.

```
 @BeanDefinition
 public final class Foo implements Bean {
   @PropertyDefinition(overrideGet = true)
   private String name;

   // generated getter as follows:
   @Override
   public String getName() { ... }
 }
```

A property can be given an alias, or alternate name.
Simply add the annotation parameter `alias = "otherName"`.
This is most useful when a property is renamed, to handle change during [deserialization](userguide-serialization.html).


The style of equals/hashCode/toString can be controlled using the annotation parameters "equalsHashCodeStyle" and
"toStringStyle". In most cases, the default "smart" setting is sufficient:

* "omit" - omit this property from equals/hashCode/toString
* "smart" - process intelligently, equivalent to "field" for immutable and "getter" for mutable
* "getter" - use the getter for equals/hashCode/toString
* "field" - use the field for equals/hashCode/toString


## Derived properties

It is possible to declare a property without a matching field.
For example, an "age" property could be derived from a "dateOfBirth" field.

To do this, annotate the getter of the derived property with [DerivedProperty](apidocs/org.joda.beans/org/joda/beans/gen/DerivedProperty.html).
Apart from the absence of a field, a derived property is very similar to a normal read-only property.


## Immutable beans

Code generated beans may be immutable.

All fields in an immutable bean must be final.
It is recommended that immutable beans are final,
do not extend any other bean class and directly implement [ImmutableBean](apidocs/org.joda.beans/org/joda/beans/ImmutableBean.html).

```
 @BeanDefinition
 public final class Foo implements ImmutableBean {
   // code generated immutable bean with public builder
 }
```


### Immutable bean customisation

Code generated immutable beans can be customized as follows.

An immutable bean can be configured to provide additional cross-property validation.
In most cases the per-property validation attribute is sufficient.
When cross-property validation is needed, this technique can be used.

Simply declare a private void method taking no arguments annotated with
[@ImmutableValidator](apidocs/org.joda.beans/org/joda/beans/gen/ImmutableValidator.html).
The method will be called during the validation phase of the constructor.

```
 @ImmutableValidator
 private void validate() {
   // validate the instance variables of the bean
 }
```

An immutable bean can be configured to apply default property values.
In most cases this is not necessary, but if the bean has lots of non-null properties it may be
desirable to have some default values.

Simply declare a private static void method taking one 'Builder' argument annotated with
[@ImmutableDefaults](apidocs/org.joda.beans/org/joda/beans/gen/ImmutableDefaults.html).
The method will be called before the empty builder is made available for population.

```
 @ImmutableDefaults
 private static void applyDefaults(Builder builder) {
   // set default property values directly into the builder
 }
```

An immutable bean can be intercepted when the bean is being built.
In most cases this is not necessary, but if the bean has a property that needs to be defaulted
from another property this can be useful.
In general, use of `@ImmutableValidator` and/or `@ImmutableDefaults` should be preferred.

Simply declare a private static void method taking one 'Builder' argument annotated with
[@ImmutablePreBuild](apidocs/org.joda.beans/org/joda/beans/gen/ImmutablePreBuild.html).
The method will be called when `build()` is invoked on the builder.

```
 @ImmutablePreBuild
 private static void preBuild(Builder builder) {
   // query the builder and make any necessary changes
 }
```

The constructor of an immutable bean can be replaced.
In most cases this is not necessary, but there may be occasional use cases.
In general, use of `@ImmutableValidator` and/or `@ImmutableDefaults` should be preferred.

A constructor with parameters matching each property must be written and annotated with
[@ImmutableConstructor](apidocs/org.joda.beans/org/joda/beans/gen/ImmutableConstructor.html).
It may be easier to generate the bean without the annotation and move the generated constructor out
into user code, adding the annotation only at that point.

```
 @ImmutableConstructor
 private MyBean(String surname, String forename) {
   // a constructor entirely under application control
 }
```

An immutable bean can be configured to cache the hash code.
In most cases this is not necessary, but if the bean is used as a hash key, then it may be helpful.

Simply set the boolean 'cacheHashCode' flag of '@BeanDefinition' to true.

```
 @BeanDefinition(cacheHashCode = true)
 public final class Foo implements ImmutableBean {
   // code generated immutable bean with cached hash code
 }
```

Immutable beans do not have set methods.
Instead, a public builder class will be generated with methods to setup an instance.
This supports code based manipulation, using the `toBuilder()` method.
The scope of the builder, public private or package-scoped, may be controlled in the bean definition.
The default is public for immutable beans and no-builder for mutable beans:

```
 @BeanDefinition(builderScope = "private")
 public final class Bar implements ImmutableBean {
   // code generated immutable bean with private builder
 }
```

A static factory may be created for an immutable bean.
This may be instead of or in addition to the builder.
The scope of the factory is always public, and it always contains all properties.
Any additional customisation should involve moving the generated factory outside the autogenerated block.
To create the factory, specify the method name:

```
 @BeanDefinition(factoryName = "of")
 public final class Bar implements ImmutableBean {
   // code generated immutable bean with static factory named "of"
 }
```

The scope of the meta-bean, public private or package-scoped, may also be controlled in the bean definition.
The default is public:

```
 @BeanDefinition(metaScope = "package")
 public final class Bar implements ImmutableBean {
   // code generated immutable bean with package-scoped meta-bean
 }
```

The scope of the generated constructor for immutable beans can be controlled.
The default is to be as private as possible for the needs of the builder, typically private:

```
 @BeanDefinition(constructorScope = "package")
 public final class Bar implements ImmutableBean {
   // code generated immutable bean with package-scoped constructor
 }
```

An option also exists to generate the ConstructorProperties annotation:

```
 @BeanDefinition(constructorScope = "public@ConstructorProperties")
 public final class Bar implements ImmutableBean {
   // code generated immutable bean with annotated public constructor
 }
```

A user-defined interface can be added to the meta-bean using the bean definition:

```
 @BeanDefinition(metaImplements = "ShapeMeta")
 public final class Square implements Shape, ImmutableBean {
   // code generated meta-bean that implements ShapeMeta
 }
```


## Immutable bean hierarchies

It is possible for an immutable bean to be non-final.
Any subclass should logically also be immutable, but must set the
`BeanDefinition` annotation value `hierarchy` to "immutable":

```
 // superclass
 @BeanDefinition
 public abstract class SuperFoo implements ImmutableBean {
   // code generation will enable an immutable subclass
 }
 
 // subclass
 @BeanDefinition(hierarchy = "immutable")
 public final class Foo extends SuperFoo {
   // code generation will connect to superclass
   // note that there is NO 'implements ImmutableBean' on the subclass
 }
```

It is also possible for a bean to be partially final.
In this case, the bean will implement `Bean` rather than `ImmutableBean`.
To get the correct behaviour, the `BeanDefinition` annotation value
`builderScope` must be set to "public".
Partially final beans can extend one another, but must all declare the builder scope.

The rules as to what works and what does not are complex.
It is recommended to keep is simple, and only have normal mutable beans or final immutable beans.


## Light beans

It is possible to generate a very light-weight bean.
This approach has no Meta class or Builder (the objects exist behind the scenes).
This is the approach with the lowest code generation.

```
 // superclass
 @BeanDefinition(style = "light")
 public final class LightBean implements ImmutableBean {
   // code generation of a light-weight immutable bean
 }
```

Internally, the bean uses reflection to implement the meta bean and builder.
As such, it may be a little slower.

Both immutable and mutable light-weight beans can be generated.


## Minimal beans

It is possible to generate a minimal bean.
This approach has no Meta class, but does have a Builder for immutable classes.
This is the approach with the medium amount of code generation.

```
 // superclass
 @BeanDefinition(style = "minimal")
 public final class MinimalBean implements ImmutableBean {
   // code generation of a minimal immutable bean
 }
```

Internally, the bean uses lambdas to implement the meta bean.

Both immutable and mutable minimal beans can be generated.


## Manual builders

It is possible to write the builder class manually and still have the generated code refer to it.
A manual builder can be an inner class or top-level class.

```
 @BeanDefinition(builderName = "PersonBuilder", constructorScope = "package")
 public final class Person implements ImmutableBean {
   // code generation of a minimal immutable bean
 }
 // using `extends BasicImmutableBeanBuilder<Person>` might be a better place to start
 public final class PersonBuilder implements BeanBuilder {
   // manual builder code
 }
```

A common way to approach manual builders is to generate the builder, copy the builder code,
add the `builderName` flag and paste the builder code ready to edit.


## Test coverage

Code generated beans are great, but they have a side effect of creating lots of untested generated code.
This can make the test coverage percentage produced by tools seem very low.
One solution to this is provided by the `JodaBeanTests` class which provides methods to artificially
provide test coverage. Of course, this can be used for good or evil! The intention is that it is used
to highlight those parts of the codebase that really do need tests, not to stop you needing tests at all.


## Links

Return to the [main user guide](userguide.html).
