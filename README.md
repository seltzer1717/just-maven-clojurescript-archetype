# just-maven-clojurescript-archetype
An archetype, for ClojureScript projects, that requires only Maven.

# Why another ClojureScript build tool?
- This isn't another build tool. It's a Maven archetype, designed to put you in control.
  - Maven archetypes are just project stereotypes that make it easy for developers to create a new project patterned for a specific purpose.
  - So no plugins required or proprietary command line tools required.
- Java shops are notoriously rigid when asked to introduce new build mechanisms into their existing DevOps pipeline system.
  - This archetype introduces no new tools. It's just a maven pom that fits neatly within a current Maven DevOps pipeline infrastructure.
- Maven is an extremely mature, maintained, and tested dependency management ecosystem.
  - Maven already has dozens of dependency, build, packaging, and deployment management features.
      - Why would you reinvent the wheel?
# Goals for this Project
- Just use Maven...only Maven.
- No plugins.
  - Plugins are sometimes not maintained or they don't do exacly what you want.
- Avoid custom or proprietary command line tools.
  - The Cognitect `clj` command line tool for Windows has a lower priority than the version for Mac and Linux.
- Avoid 'magic' jars, e.g. jars that are built and shared for download outside a standard maven build process.
  - You might be wondering why we don't use the Windows 'magic' jar on the ClojureScript site.
  - Well, that is likely an 'uber-jar', but built in a way that I don't understand.
  - It's contents include artifacts (not dependencies) that I cannot find in the Github ClojureScript repo.
    - FYI - God bless all open source contributors and projects.
      - I will **NEVER** criticize or complain about any open-source project...ever.
      - It's free...duh. Do you have any idea how expensive it is to create software?
      - The ClojureScript maintainers are nothing short of **awesome!**

- But this project uses XML 😒
  - Okay - can we stop kicking XML around? Please?
  - XML gives you autocomplete in most development editors!
  - It's what all the Maven documentation is written in.
  - As Rich would say, creating a pom.edn feature is a NON-GOAL.
    - You can create a solution for yourself - it's certainly possible using the `exec-maven-plugin`.
# Getting Started - Prerequisites
- Install Java - https://jdk.java.net/17/
- Install Maven - https://maven.apache.org/download.cgi
- Install Node - https://nodejs.org/en/download/
- Add the above commands  to your user `path` (OS specific) to include the above.
  - Assume you know how to do this.
- Verify your installs:
  - `java --version`
  - `mvn --version`
  - `node --version`
# Getting Started - Using the Archetype
- Navigate to your Maven based Java projects directory.
  - You should really designate a single directory on your computer that holds maven projects. I recommend `C:/Users/<you>/Documents/Development/Java/projects` (Windows 11). I assume you can determine the equivalent for your OS.
- Just run the following command at your OS command prompt (Wondows 11, adjust for your OS).
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
|   clj.bat
|   cljs.bat
|   cljs_help.txt
|   pom.xml
|
+---.clojure
|   +---opts
|   |       compile_opts.edn
|   |       compile_test_opts.edn
|   |       compile_repl_opts.edn
|   |       repl_opts.edn
|   |
|   \---scripts
|           cljs.clj
|           compile.clj
|
\---src
    +---main
    |   +---clojurescript
    |   |   \---com
    |   |       \---example
    |   |           \---foo
    |   |                   core.cljs
    |   |
    |   \---resources
    |           required_for_test.txt
    |
    \---test
        +---clojurescript
        |   \---com
        |       \---example
        |           \---foo
        |                   core_test.cljs
        |                   test_suite.cljs
        |
        \---resources
                required_for_test.txt
```
# Compiling, testing, and running Clojure(Script)
Maven is initiated with the `mvn` CLI command.
## Starting a Clojure REPL
- `mvn exec:java@clj`
## Starting a ClojureScript REPL
- `mvn exec:java@cljs-repl`
## Compiling ClojureScript source main
- `mvn exec:java@cljs-compile`
## Compiling ClojureScript source tests
- `mvn exec:java@cljs-test-compile`
## Running ClojureScript tests
- `mvn exec:java@cljs-test`
## Maven can be verbose - Running Maven in 'quiet' Mode
- `mvn -q exec:java@clj`
- `mvn -q exec:java@cljs-repl`
- `mvn -q exec:java@cljs-compile`
- `mvn -q exec:java@cljs-test-compile`
- `mvn -q exec:java@cljs-test`
## Execution as Part of Maven Lifecycle
- `mvn clean install`
  - Cleans (removes `target` folder)
  - Compiles source main code
  - Compiles source test code
  - installs (does nothing - see aws archetype for creating output artifacts)
  - Can also run 'quietly' `mvn -q clean install`
## Too Many Key Strokes
- Create shell scripts
- `clj.bat` starts a Clojure REPL
- `cljs.bat` runs cljs.main with any arguments you provide
- Creat your own.

# How it Works - Project Directory Structure, Config, Scripts, and `pom.xml`
## Exec Maven Plugin
- ClojureScript compilation is Google Closure compilation which is a Java process.
- The ClojureScript dependency jar doesn't compile cljs.main and other classes so we'll leverage Clojure to run ClojureScript.
- The `exec-maven-plugin` let's you run java code in the same thread as the regular Maven JVM process (`mvn ...`).
- This means we can use Clojure to compile ClojureScript.
- The archetype uses the standard Maven ClojureScript dependency so no mysteries.
## The `.clojure` Directory
- `opts` directory
  - The `opts` directory holds the EDN options files that the ClojureScript `cljs.main` namespace will use.
  - There are 4 EDN config files, `compile_opts.edn` (compile regular source), `compile_test_opts.edn` (compile tests), `compile_repl_opts.edn` (REPL compile), and `repl_opts.edn` (REPL specific config that is not compiler specific config).
- `scripts` directory
  - The `scripts` directory holds the Clojure scripts which are used to execute the ClojureScript `cljs.main` function, the entry point for all ClojureScript compilation, testing, and REPL initiation.
  - There are 2 scripts initially. The first (`cljs.clj`) is a generic script useful for any `cljs.main` initiation including REPLs. The second (`compile.clj`) is specific to compilation.
  - You can create your own as needed although you'll find it's better just to use these and create `exec:java` `executions` in the `pom.xml`.
    - There are occaisions when you'll want to create your own script. I will show an example of creating an AWS Lambda handler function that uses a special script.
## Let's Look at `compile_opts.edn`
- This is just a small set of the compile options available, but it's a good example.
- See the ClojureScript compiler options page for details: https://clojurescript.org/reference/compiler-options and for the complete set of options http://cljs.github.io/api/compiler-options/.
```
{:main          "cloud.seltzer1717.aws.report"
 :output-dir    "target/js"
 :output-to     "target/js/index.js"
 :optimizations :none
 :target        :nodejs}
```
- Options used in the `compile_opts.edn` file initially set by the archetype.
  - `:main` defines the entry point namespace for node execution.
  - `:output-dir` defines where generated js files will be written.
  - `:output-to` defines the name of the js file which is the load target for noad and, in turn, loads `cljs`, `goog`, and others.
    - Regular node moduless will be written to the root `node_modules` folder.
  - `:optimizations` defines the level of optimizations the Google Closure compile will execute.
    - For node applications , it's best just to leave this as `:none`
  - `:target` defines which ecosystem Google Closure will target during compilation.
- See https://clojurescript.org/index for details on both compiler and REPL options.
## Let's Look at the `cljs.clj` Script
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
- The compile.clj script file is exactly the same as the cljs.clj file except that it doesn't check for REPL exection.
## Let's Look at the `pom.xml` File
```
<?xml version="1.0" encoding="UTF-8" ?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.foo.aws</groupId>
  <artifactId>foo-lambda</artifactId>
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
                <additionalClasspathElement>${basedir}/${clojurescript.source.dir}</additionalClasspathElement>
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
                <additionalClasspathElement>${basedir}/${clojurescript.source.dir}</additionalClasspathElement>
                <additionalClasspathElement>${basedir}/${clojurescript.test.dir}</additionalClasspathElement>
              </additionalClasspathElements>
              <arguments>
                <argument>${clojure.scripts.dir}/cljs.clj</argument>
                <argument>--compile-opts</argument>
                <argument>${clojure.opts.dir}/compile_repl_opts.edn</argument>
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
              <additionalClasspathElements>
                <additionalClasspathElement>${basedir}/${clojurescript.source.dir}</additionalClasspathElement>
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
            <configuration>
              <classpathScope>compile</classpathScope>
              <additionalClasspathElements>
                <additionalClasspathElement>${basedir}/${clojurescript.source.dir}</additionalClasspathElement>
                <additionalClasspathElement>${basedir}/${clojurescript.test.dir}</additionalClasspathElement>
              </additionalClasspathElements>
              <arguments>
                <argument>${clojure.scripts.dir}/cljs.clj</argument>
                <argument>--compile-opts</argument>
                <argument>${clojure.opts.dir}/compile_test_opts.edn</argument>
                <argument>--target</argument>
                <argument>nodejs</argument>
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
              <additionalClasspathElements>
                <additionalClasspathElement>${basedir}/${clojurescript.source.dir}</additionalClasspathElement>
                <additionalClasspathElement>${basedir}/${clojurescript.test.dir}</additionalClasspathElement>
              </additionalClasspathElements>
              <arguments>
                <argument>${clojure.scripts.dir}/cljs.clj</argument>
                <argument>--target</argument>
                <argument>nodejs</argument>
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
    </plugins>
  </build>

</project>

```
- This is just a standard Maven project.
- We have the standard Maven coordinates.
  - `groupId`
  - `artifactId`
  - `version`
- Notice the packaging is `pom` and not `jar`. A ClojureScript project does fall neatly into standard packaging like `jar`. Clojure, ont the other hand, does. `pom` packaging allows us to create ClojureScript packaging and project lifecycle.
- Almost everything is defined as a property in the `properties` section. This makes it easier to change `version`s, paths, main namespaces in one place, rather than having to search the entire `pom.xml` file to make an update.
- The `dependencies` start with ClojureScript. Please note the default ClojureScript `version` is `1.10.879`. The versions after that have a defect impacting developers using Windows.
  - Note that the Clojure sub-dependency is excluded. This is to include the most recent version of Clojure.
  - We also exclude `commons-codec`. The existing `version` used by ClojureScript has a known vulnerability so I load a more recent `version` to avoid the vulnerability.
    - Isn't Maven great? You can correct vulnerabilities not yet corrected by a repository.
- Next we have the Clojure `dependency` which replaces the one ClojureScript pulls in.
- Then `commons-codec` with a new verion which fixes the vulnerability.
- Then `core.async` to support asynchronous JavaScript.
## The Maven `build` Section
- `pluginManagement` is generally only needed if you'll use the `pom.xml` file as a parent pom for another project or `plugins` section of current pom.
  - It defines the coordinates for the  build plugins that will be used, including the `version`s, but does not have the specific build `configurations` that we'll discuss below.
  - Note we have the `exec-maven-plugin` that makes the `archetype` possible. More below.
- The `plugins` section appears, initially, to be a copy of what is in the `pluginManagement` section but it's not. In the `plugins` section we'll provide more detail for builds, tests, and packaging.
## The `exec-maven-plugin` Plugin
- It allows projects to leverage their own `compile`, `test`, `packaging`, and `deployment` actions (or phases). Phases are how Maven defines project activities. See https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html for more about the Maven Build Lifecycle.
- The plugin defines a set of `executions` which can be called directly or associated to a Maven build phase.
- An `execution` can have an `id` which names the `execution` for the Maven's command line or a `phase` can be added which is triggered by the Maven lifecycle.
- The `configuration` sections configure the execution including classpath, system properties, command line arguments and more.
- The `exec-maven-plugin` has two possible `goals`, `java` or `exec`. We use the `jova` goal only in this project. It allows us to execute our own Java code as part of the Maven build process. The `exec` plugin let's you execute any arbitrary program in a separate process.
- You can review the details of the `exec-maven-plugin` here https://www.mojohaus.org/exec-maven-plugin/.
## The `clj` Execution
- This execution is purely for initiating Clojure. In fact, if executed directly, will start a Clojure, REPL as that's the default for `clojure.main`.
  - `clojure.main` is the code that runs for all the executions.
- In this case we're just adding the ClojureScript source directory to the classpath.
  - The `exec-maven-plugin` will automatically add the source main, source test, source main output, and source test output folders to the classpath. For ClojureScript, compilation folders are defined separately in the EDN compile files so we don't define them in to `pom.xml` file.
    - This avoids issues with the ClojureScript compiler when compiling main vs. test code.
- The `commandlineArgs` element allows this execution to use clojure.main with arguments from the maven command line, perhaps passed in a batch (shell) script. See below.
## The `cljs-repl` Execution
- This execution starts the cljs REPL.
- As above, just adds the ClojureScript source to the classpath just like the `clj` execution.
- The `arguments` section is where we start leveraging the CLJS compiler:
  - `--compile-opts` sets the edn file holding the compiler options for the cljs REPL.
  - `--repl-opts` sets the edn file holding the REPL options.
  - `--repl-env` sets the target environment for the REPL. In this case, node.
  - `--repl` which is the single main option which starts the cljs REPL.n
- The compile option is needed because using the REPL will need compilation as well. It also makes sure that compiled files for regular compilation, test compilation, and REPL compilation are kept separate.
- There are no `--repl-opts` defined by default. You can review the set of possible options here https://clojurescript.org/reference/repl-options and a more complete set of options here http://cljs.github.io/api/repl-options/.
## The `cljs-compile` Execution
- The `cljs-compile` execution compiles your ClojureScript source. This archetype is specifically for node development. Node execution is generally not focused on the size of the build artifacts as they are not pushed to clients, just to servers.
  - `--compile-opts` sets compiler options just as above.
  - `--target` sets runtime target 
  - `--compile` is tha main option - compilation
  - The last `argument` tells the ClojureScript compiler to use a specific namespace as the entry point namespace.
## The `cljs-test-compile` Execution
- This `execution` is almost identical to the `cljs-compile` `execution` except that it is focused on compiling tests rather than the regular source code.
- `compile-opts` keep test generated JavaScript in it's own folder.
- This execution is also associated to the compile `phase`.
  - This make sense. When a Java maven project is built, the source and test code are compiled during the compile `phase`.
## The `cljs-test` Execution
- This `execution` is designed to run the ClojureScript tests.
- It uses the initial options of `--compile-opts` and `--target`. And it uses the `--main` main option.
- This `--main` option passes a cljs namespace to execute. In this case the test suite namespace.
# General Archetype for `node` Projects
- This archetype is for plain node projects.
- There are other cloud.seltzer1717 archetypes you might find useful:
  - `just-maven-clojure-archetype` for Clojure projects
  - `just-maven-clojurescript-web-archetype` for ClojureScript web projects
  - `just-maven-clojurescript-aws-archetype` for ClojureScript AWS projects
- The idea is for **YOU** to customize your own `pom.xml` file in a way that best suites your needs.
