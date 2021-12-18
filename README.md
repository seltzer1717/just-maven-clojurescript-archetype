# just-maven-clojurescript-archetype
An archetype, for ClojureScript projects, that requires only Maven.

# Why another ClojureScript build tool?
- This isn't a tool, it's just a Maven archetype, designed to put you in control.
- Java shops are notoriously rigid when asked to introduce new build mechanisms into an existing DevOps pipeline system.
  - This is just Maven and Java.
- Maven is an extremely mature, maintained, and tested dependency management ecosystem.
- Maven already has every possible dependency management, build, packaging, and deployment feature. Why would you reinvent the wheel(s)?
# Goals for this Project
- Just use Maven...only Maven.
- Don't be restricted by plugins that will or will not be maintained or will or won't do what you need.
- I want to avoid custom or proprietary command line tools for the same reason.
  - Windows has been deprioritized, yet Windows laptops dominate in the consulting space.
- I want to avoid 'magic' jars, e.g. jars that are built and shared for download outside a standard maven build process.
  - FYI - God bless all open source contributors and projects. I will NEVER criticize or complain about any open-source project...ever. It's free...duh. Do you have any idea how expensive it is to create software?
- But this project uses XML :(
  - Okay - can we stop kicking XML around? Please?
  - XML gives you autocomplete in most development editors!
  - It's what all the Maven documentation is written in.
  - As Rich would say, creating a pom.edn feature is a NON-GOAL.
  - I regard the idea that all XML config should be EDN akin to the idea that SQL is bad and creating ORM facilities in every language is a good idea. It's not!
# How? This is ClojureScript, not Java!
- Not sure you're aware but ClojureScript compilation is Google Closure compilation, which is a Java process...
- ClojureScript is...well...awesome! Don't be fooled by the very high learning curve. ClojureScript compilation is fully featured and quite powerful.
- Maven let's you manage everything. The key is the Exec Maven Plugin. It's the key opening the door to your bright future as a ClojureScript developer!
# Exec Maven Plugin
- It let's you run java code in the same thread as the regular Maven JVM process (`mvn ...`).
- And Clojure is ... wait for it ... Java!
- This means we can use Clojure to compile ClojureScript.
  - You might be wondering why we don't use the Windows 'magic' jar on the ClojureScript site. Well, that is likely an 'uber-jar', but built in a way that I don't understand. It's contents include artifacts (not dependencies) that I cannot find in the Github ClojureScript repo.
  - We will use the standard Maven ClojureScript dependency in this archetype. Ahem...Just Maven.
# Getting Started - Prerequisites
- Install Java - https://jdk.java.net/17/
- Install Maven - https://maven.apache.org/download.cgi
- Set up your path (OS specific) to include the above.
  - I'll assume you know how to do this.
# Getting Started - Using the Archetype
- Navigate to your Maven based Java projects directory.
  - You should really designate a directory on your computer that will hold maven projects. I recommend `C:/Users/<you>/Documents/Development/Java/projects` (Windows 11). I assume you can determine an equivalent for your O.S.
- Just run the following command at your OS command prompt.
  - Below is the one for Windows Command Prompt. I assume you know how to construct a mult-line command in your O.S.
```
mvn archetype:generate ^
-DarchetypeGroupId=cloud.seltzer1717.clojure ^
-DarchetypeArtifactId=just-maven-clojurescript-archetype ^
-DarchetypeVersion=0.2-RELEASE
```
The output looks something like this (it's interactive). If you say `N` at the `<--- FINAL PROMPT --->`, you can specify all the property values, including values for dependency versions as seen below:

```
C:\Users\blah\projects>mvn archetype:generate ^
More? -DarchetypeCatalog=local,remote ^
More? -DarchetypeGroupId=cloud.seltzer1717.clojure ^
More? -DarchetypeArtifactId=just-maven-clojurescript-archetype ^
More? -DarchetypeVersion=0.2-RELEASE
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] --------------------------------[ pom ]---------------------------------
[INFO] 
[INFO] >>> maven-archetype-plugin:3.0.1:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO] 
[INFO] <<< maven-archetype-plugin:3.0.1:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO] 
[INFO] 
[INFO] --- maven-archetype-plugin:3.0.1:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
[INFO] Archetype repository not defined. Using the one from [cloud.seltzer1717.clojure:just-maven-clojurescript-archetype:0.2-RELEASE] found in catalog local
Define value for property 'groupId': com.example.foo
Define value for property 'artifactId': cranberry-fizzy-juice
Define value for property 'version' 1.0-SNAPSHOT: : 
Define value for property 'package' com.example.foo: : 
[INFO] Using property: clojure-version = 1.10.2
[INFO] Using property: clojurescript-version = 1.10.879
[INFO] Using property: commons-codec-version = 1.15
[INFO] Using property: core-async-version = 1.5.640
[INFO] Using property: maven-compiler-source = 17
[INFO] Using property: maven-compiler-target = 17
Confirm properties configuration:
groupId: com.example.foo
artifactId: cranberry-fizzy-juice
version: 1.0-SNAPSHOT
package: com.example.foo
clojure-version: 1.10.2
clojurescript-version: 1.10.879
commons-codec-version: 1.15
core-async-version: 1.5.640
maven-compiler-source: 17
maven-compiler-target: 17
<--- FINAL PROMPT --->
 Y: : Y
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Archetype: just-maven-clojurescript-archetype:0.2-RELEASE
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: groupId, Value: com.example.foo
[INFO] Parameter: artifactId, Value: cranberry-fizzy-juice
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: package, Value: com.example.foo
[INFO] Parameter: packageInPathFormat, Value: com/example/foo
[INFO] Parameter: clojure-version, Value: 1.10.2
[INFO] Parameter: package, Value: com.example.foo
[INFO] Parameter: core-async-version, Value: 1.5.640
[INFO] Parameter: groupId, Value: com.example.foo
[INFO] Parameter: maven-compiler-target, Value: 17
[INFO] Parameter: artifactId, Value: cranberry-fizzy-juice
[INFO] Parameter: clojurescript-version, Value: 1.10.879
[INFO] Parameter: commons-codec-version, Value: 1.15
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] Parameter: maven-compiler-source, Value: 17
[INFO] Project created from Archetype in dir: C:\blah\projects\cranberry-fizzy-juice
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  04:12 min
[INFO] Finished at: 2021-12-16T16:18:29-08:00
[INFO] ------------------------------------------------------------------------
```
The following directory structure is created for you `cranberry-fizzy-juice` (the `artifactId` you specified) project:
```
cranberry-fizzy-juice
│   clj.bat
│   cljs.bat
│   cljs_help.txt
│   pom.xml
│   print
│   
├───.clojure
│   ├───opts
│   │       compile_opts.edn
│   │       compile_test_opts.edn
│   │       REPL_opts.edn
│   │       
│   └───scripts
│           cljs.clj
│           compile.clj
│
└───src
    ├───main
    │   ├───clojurescript
    │   │   └───com
    │   │       └───example
    │   │           └───foo
    │   │                   core.cljs
    │   │
    │   └───resources
    │           required_for_test.txt
    │
    └───test
        ├───clojurescript
        │   └───com
        │       └───example
        │           └───foo
        │                   core_test.cljs
        │                   test_suite.cljs
        │
        └───resources
                required_for_test.txt
```
# The `.clojure` directory
- `opts` directory
  - The `opts` directory holds the EDN options files that the ClojureScript `cljs.main` namespace will use.
  - There are 3 possible EDN config files, one for compile (`compile_opts.edn`), one for test compile (`compile_test_opts.edn`), and one for REPL options (`REPL_opts.edn`).
- `scripts` directory
  - The `scripts` directory holds the Clojure scripts which are used to execute the ClojureScript `cljs.main` function, the entry point for all ClojureScript compilation, testing, and REPL initiation.
  - There are 2 scripts initially. The first (`cljs.clj`) is a generic script useful for any `cljs.main` initiation including REPLs. The second (`compile.clj`) is specific to compilation.
  - You can create your own as needed although you'll find it's better just to use these and create `exec:java` `executions` in the pom.xml.
  - There are occaisions when you'll want to create your own script. I will show an example of creating an AWS Lambda handler function that uses a special script.
# Let's look at `compile_opts.edn`
- This is just a small set of the compile options available, but it's a good example.
- See the ClojureScript compiler options page for details: https://clojurescript.org/reference/compiler-options and for the complete set of options http://cljs.github.io/api/compiler-options/.
```
{:main          "cloud.seltzer1717.aws.report"
 :output-dir    "target/js"
 :output-to     "target/js/index.js"
 :optimizations :none
 :target        :nodejs
 :deps-cmd      "npm"}
```
- Options used in the `compile_opts.edn` file initially set by the archetype.
  - `:main` defines the entry point namespace for node execution.
  - `:output-dir` defines where generated js files will be written.
  - `:output-do` defines the name of the js file which is the load target for noad and, in turn, loads `cljs`, `goog`, and other `node_modules`.
  - `:optimizations` defines the level of optimizations the Google Closure compile will execute.
  - `:target` defines which ecosystem Google Closure will target during compilation.
  - `:deps-cmd` defines which JavaScript tool will be used to pull down JavaScript dependencies.
- See https://clojurescript.org/index for details on both compiler and REPL options.
# Let's look at the `cljs.clj` script
- Notice that this is Clojure, not ClojureScript.
- ClojureScript compilation is executed through Clojure.
- The ClojureScript depedency jar does not compile cljs.main to a class file, it's just a .clj file
- Because of that, it needs to executed via Clojure's clojure.main class.
```
;; Require cljs.main
(require '(cljs [main :as m]))

;; Call main.
(apply m/-main *command-line-args*)

;; When ClojureScript REPL ends, exit Clojure
(if (= "--REPL"
    (last *command-line-args*))
    (System/exit 0))

```
- This Clojure script file is designed to be generic and, as such, includes the last section which just executes Clojure after executing the ClojureScript REPL.
- The compile.clj script file is exactly the same as the cljs.clj file except that it doesn't have the REPL exection which is not needed for compilation.
# Let's look at the `pom.xml` file
```
<?xml version="1.0" encoding="UTF-8" ?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.example.foo</groupId>
  <artifactId>cranberry-fizzy-juice</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>pom</packaging>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
    <clojure.version>1.10.2</clojure.version>
    <clojurescript.version>1.10.879</clojurescript.version>
    <commons-codec.version>1.15</commons-codec.version>
    <core.async.version>1.5.640</core.async.version>
    <clojure.scripts.dir>.clojure/scripts</clojure.scripts.dir>
    <clojure.opts.dir>.clojure/opts</clojure.opts.dir>
    <clojurescript.source.dir>src/main/clojurescript</clojurescript.source.dir>
    <clojurescript.source.entrynamespace>com.foo.aws.core</clojurescript.source.entrynamespace>
    <clojurescript.source.testentry>com.foo.aws.test-suite</clojurescript.source.testentry>
    <clojurescript.source.output.dir>target/js</clojurescript.source.output.dir>
    <clojurescript.test.dir>src/test/clojurescript</clojurescript.test.dir>
    <clojurescript.test.output.dir>target/test-js</clojurescript.test.output.dir>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>clojurescript</artifactId>
      <version>${clojurescript.version}</version>
      <exclusions>
        <!-- Excluding Clojure dependency and updating version below. -->
        <exclusion>
          <groupId>org.clojure</groupId>
          <artifactId>clojure</artifactId>
        </exclusion>
        <!-- Vulnerability in current Clojurescript with commons-codec version. Excluding and adding higher version below -->
        <exclusion>
          <groupId>commons-codec</groupId>
          <artifactId>commons-codec</artifactId>
        </exclusion>
      </exclusions>
    </dependency>
    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>clojure</artifactId>
      <version>${clojure.version}</version>
    </dependency>
    <dependency>
      <groupId>commons-codec</groupId>
      <artifactId>commons-codec</artifactId>
      <version>${commons-codec.version}</version>
    </dependency>
    <!-- Adding to support core.async node processing. -->
    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>core.async</artifactId>
      <version>${core.async.version}</version>
    </dependency>
  </dependencies>

  <build>
    <sourceDirectory>${basedir}/${clojurescript.source.dir}</sourceDirectory>
    <testSourceDirectory>${basedir}/${clojurescript.test.dir}</testSourceDirectory>
    <outputDirectory>${basedir}/${clojurescript.source.output.dir}</outputDirectory>
    <testOutputDirectory>${basedir}/${clojurescript.test.output.dir}</testOutputDirectory>
    <pluginManagement>
      <plugins>
        <plugin>
          <groupId>org.codehaus.mojo</groupId>
          <artifactId>exec-maven-plugin</artifactId>
          <version>3.0.0</version>
          <configuration>
            <mainClass>clojure.main</mainClass>
          </configuration>
        </plugin>
        <plugin>
          <groupId>org.apache.maven.plugins</groupId>
          <artifactId>maven-assembly-plugin</artifactId>
          <version>3.3.0</version>
        </plugin>
      </plugins>
    </pluginManagement>
    <plugins>
      <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <executions>
          <execution>
            <id>clj</id>
            <configuration>
              <additionalClasspathElements>
                <additionalClasspathElement>${project.build.sourceDirectory}</additionalClasspathElement>
              </additionalClasspathElements>
              <commandlineArgs>${clojure.args}</commandlineArgs>
            </configuration>
            <goals>
              <goal>java</goal>
            </goals>
          </execution>
          <execution>
            <id>cljs-repl</id>
            <configuration>
              <additionalClasspathElements>
                <additionalClasspathElement>${project.build.sourceDirectory}</additionalClasspathElement>
              </additionalClasspathElements>
              <arguments>
                <argument>${clojure.scripts.dir}/cljs.clj</argument>
                <argument>--compile-opts</argument>
                <argument>${clojure.opts.dir}/compile_opts.edn</argument>
                <argument>--repl-opts</argument>
                <argument>${clojure.opts.dir}/REPL_opts.edn</argument>
                <argument>--repl-env</argument>
                <argument>node</argument>
                <argument>--repl</argument>
              </arguments>
            </configuration>
            <goals>
              <goal>java</goal>
            </goals>
          </execution>
          <execution>
            <?m2e ignore?>
            <id>cljs-compile</id>
            <phase>compile</phase>
            <configuration>
              <systemProperties>
                <systemProperty>
                  <key>maven.source.dir</key>
                  <value>${project.build.sourceDirectory}</value>
                </systemProperty>
              </systemProperties>
              <additionalClasspathElements>
                <additionalClasspathElement>${project.build.sourceDirectory}</additionalClasspathElement>
                <additionalClasspathElement>${project.build.testSourceDirectory}</additionalClasspathElement>
                <additionalClasspathElement>${basedir}</additionalClasspathElement>
              </additionalClasspathElements>
              <arguments>
                <argument>${clojure.scripts.dir}/compile.clj</argument>
                <argument>--compile-opts</argument>
                <argument>${clojure.opts.dir}/compile_opts.edn</argument>
                <argument>--target</argument>
                <argument>node</argument>
                <argument>--compile</argument>
                <argument>${clojurescript.source.entrynamespace}</argument>
              </arguments>
            </configuration>
            <goals>
              <goal>java</goal>
            </goals>
          </execution>
          <execution>
            <?m2e ignore?>
            <id>cljs-test-compile</id>
            <phase>compile</phase>
            <configuration>
              <systemProperties>
                <systemProperty>
                  <key>maven.source.dir</key>
                  <value>${project.build.sourceDirectory}</value>
                </systemProperty>
              </systemProperties>
              <additionalClasspathElements>
                <additionalClasspathElement>${project.build.sourceDirectory}</additionalClasspathElement>
                <additionalClasspathElement>${project.build.testSourceDirectory}</additionalClasspathElement>
                <additionalClasspathElement>${basedir}</additionalClasspathElement>
              </additionalClasspathElements>
              <arguments>
                <argument>${clojure.scripts.dir}/cljs.clj</argument>
                <argument>--compile-opts</argument>
                <argument>${clojure.opts.dir}/compile_test_opts.edn</argument>
                <argument>--target</argument>
                <argument>node</argument>
                <argument>--compile</argument>
                <argument>${clojurescript.source.testentry}</argument>
              </arguments>
            </configuration>
            <goals>
              <goal>java</goal>
            </goals>
          </execution>
          <execution>
            <?m2e ignore?>
            <id>cljs-test</id>
            <phase>test</phase>
            <configuration>
              <systemProperties>
                <systemProperty>
                  <key>maven.source.dir</key>
                  <value>${project.build.sourceDirectory}</value>
                </systemProperty>
              </systemProperties>
              <additionalClasspathElements>
                <additionalClasspathElement>${project.build.sourceDirectory}</additionalClasspathElement>
                <additionalClasspathElement>${project.build.testSourceDirectory}</additionalClasspathElement>
                <additionalClasspathElement>${basedir}</additionalClasspathElement>
              </additionalClasspathElements>
              <arguments>
                <argument>${clojure.scripts.dir}/cljs.clj</argument>
                <argument>--compile-opts</argument>
                <argument>${clojure.opts.dir}/compile_test_opts.edn</argument>
                <argument>--target</argument>
                <argument>node</argument>
                <argument>--main</argument>
                <argument>${clojurescript.source.testentry}</argument>
                <argument>foo</argument>
              </arguments>
            </configuration>
            <goals>
              <goal>java</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>3.3.0</version>
        <executions>
          <execution>
            <id>assemble-all</id>
            <configuration>
              <descriptors>
                 <descriptor>src/assembly/reportEvent.xml</descriptor>
                 <descriptor>src/assembly/dependencies.xml</descriptor>
               </descriptors>
             </configuration>
          </execution>
          <execution>
            <id>assemble-app</id>
            <phase>package</phase>
            <configuration>
              <descriptors>
                 <descriptor>src/assembly/reportEvent.xml</descriptor>
               </descriptors>
             </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>

</project>

```
- Yes, we're producing a standard Maven project with the regular `pom.xml`.
- We have the standard Maven coordinates.
  - `groupId`
  - `artifactId`
  - `version`
  - Notice the packaging is `pom` and not `jar`. We're not creating with ClojureScript, generally speaking. We're creating the output artifacts with the Maven Assembler Plugin.
- Almost everything is defined as a property in the `properties` section. This makes it easier to change `version`s, paths, main namespaces etc. rather than having to search the `pom.xml` file looking for where to update it.
- The `dependencies` start with ClojureScript. Please note the default ClojureScript `version` is `1.10.879`. The versions after that have a defect impacting Windows users.
  - Note that the Clojure sub-dependency is excluded. This is to include the most recent version of Clojure.
  - We also exclude `commons-codec`. The existing `version` used by ClojureScript has a known vulnerability so I load a more recent `version` to avoid the vulnerability.
    - Isn't Maven great? You can correct vulnerabilities not yet corrected by a repository.
- Next we have the Clojure `dependency` which REPLaces the one ClojureScript pulls in.
- Then `commons-codec`, the fix for the vulnerability.
- Then `core.async` to support asynchronous JavaScript.
# The Maven `build` section
- The `build` section defines source, test, and output folders. Notice these refer to the `properties`.
- That is followed by `pluginManagement` which is generally only needed if you'll use this `pom.xml` file as a parent pom for another project or `plugins` section of current pom. It defines the build `plugins` that will be used, including the `version`s, but do not have the specific build `configurations` that we'll discuss below.
  - Note we have the `exec-maven-plugin` that makes the `archetype` possible. More below.
  - We also use the `maven-assembly-plugin`. This is a power tool be building build output artifacts like zip or jar files.
- The `plugins` section appears, initially, to be a copy of what is in the `pluginManagement` section but it's not. In the `plugins` section we'll provide more detail for builds, tests, and packaging.
# The `maven-exec-plugin`
- It allows projects to leverage their own `compile`, `test`, `packaging`, and `deployment` actions (or phases). Phases are how Maven defines project activities. See https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html for more about the Maven Build Lifecycle.
- The plugin defines a set of `executions` which can be called directly or associated to a Maven build phase.
  - An `execution` can have an `id` which names the `execution` for...well...execution from command line directly or as part of Maven's standard build `phase`s.
  - The `configuration` section to configure the `execution` including classpath, system properties, command line arguments and more.
  - The `goals` are how you specify which method of the plugin you want to use in that execution. The `exec-maven-plugin` has two possible `goals`, `java` or `exec`. We use the `jova` goal only in this project. It allows us to execute our own Java code as part of the Maven build process. The `exec` plugin let's you execute any arbitrary program in a separate process.
- You can review the details of the `exec-maven-plugin` here https://www.mojohaus.org/exec-maven-plugin/.
# The `clj` execution
- This execution is purely for initiating Clojure. And, in fact, if executed directly will start a Clojure REPL as that's the default for `clojure.main`.
- `clojure.main` is the code that runs for all the executions.
- In this case we're just adding the `project.build.sourceDirectory` to the classpath for access by Clojure in the REPL or as a script.
- The `commandlineArgs` element allows this execution to use clojure.main with arguments from the maven command line, perhaps passed in a batch (shell) script. See below.
# The `cljs-repl` execution
- This execution starts the cljs REPL
- It still just adds the `project.build.sourceDirectory` to the classpath just like the `clj` execution.
- The `arguments` section is where we start leveraging the cljs compiler. There are four options (3 initial and 1 main) we're setting: `--compile-opts`, `--repl-opts`, `--repl-env`, and `--repl`.
  - `--compile-opts` sets the edn file holding the compiler options for the cljs REPL.
  - `--repl-opts` sets the edn file holding the REPL options.
  - `--repl-env` sets the target environment for the REPL. In this case, node.
  - `--repl` which is the single main option which starts the cljs REPL.n
- The compile option is needed because using the REPL will need compilation as well. It also makes sure that compiled files for regular compilation, test compilation, and REPL compilation are kept separate.
- There are no `--repl-opts` defined by default. You can review the set of possible options here https://clojurescript.org/reference/repl-options and a more complete set of options here http://cljs.github.io/api/repl-options/.
# The `cljs-compile` execution
- The `cljs-compile` execution just compiles your ClojureScript source. This archetype is directed at node development. Node execution is generally not focused on the size of the build artifacts as they are not pushed to clients and are just deployed to servers.
- It  uses the initial options `--compile-opts` and `--target`, and, of course, the main option of `--compile`.
- The last `argument` tells the ClojureScript compiler to use a specific namespace as the entry point namespace.
- The main entrypoint namespace is not required, but in most cases it makes sense to have a main entrypoint namespace.
- The last thing to note is this `execution` linked to the `phase` compile. This means that this `execution` will be executed when maven applies the compile `phase` is otherwise initiated.
# The `cljs-test-compile` execution
- This `execution` is almost identical to the `cljs-compile` `execution` except that it is focused on compiling tests rather than the regular source code.
- This execution is also associated to the compile `phase`. This make sense. When a Java maven project is built, the source and test code are compiled during the compile `phase`.
# The `cljs-test` execution
- This `execution` is designed to run the ClojureScript tests.
- It uses the initial options of `--compile-opts` and `--target`. And it uses the `--main` main option.
- This `--main` option passes a cljs namespace to execute. In this case the test suite namespace.
# General Archetype for `node` projects
- This archetype is for plain node projects.
- There are other cloud.seltzer1717 archetypes you might find useful:
  - `just-maven-clojure-archetype` for Clojure projects
  - `just-maven-clojurescript-web-archetype` for ClojureScript web projects
  - `just-maven-clojurescript-aws-archetype` for ClojureScript AWS projects
- I will try to add more when I think there is another pattern worth sharing
- It should be clear now that these `just-maven` archetypes let you have full control over the build process and don't constrain you to proprietary command line tools or plugins that may or may not be maintained.
- The idea is for YOU to customize your own `pom.xml` file that best suites your needs.
- Remember that Maven is a very mature solution. If you need some compile, test, package, or deploy feature, chances are, Maven already supports it with some existing plugin.

