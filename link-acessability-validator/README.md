# 链接有效性检测

## 在项目中使用

如果需要在maven项目中使用,需要在`pom.xml`文件中加入

```xml
  <!--定义snapshots库和releases库的nexus地址-->
    <distributionManagement>
        <repository>
            <id>releases</id>
            <url>
                http://nexus.freecode.tech/repository/maven-releases/
            </url>
        </repository>
        <snapshotRepository>
            <id>snapshots</id>
            <url>
                http://nexus.freecode.tech/repository/maven-snapshots/
            </url>
        </snapshotRepository>
    </distributionManagement>
```

并在其中加入项目依赖

```xml
<dependency>
  <groupId>tech.freecode</groupId>
  <artifactId>link-acessability-validator</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

调用`UrlAccessibilityValidatorUtils`即可完成对markdown文档中的链接可达性检测

```java
File file = new File("path-to-markdown.md");
List<UrlAccessibilityValidator.ValidationResult> results =
                UrlAccessibilityValidatorUtils.validate(file);
```

## 在shell中使用

使用下面的命令进行安装之后,即可以使用在shell中使用`url-access-validate`对当前目录下的markdown文档的有效性进行检测

```bash
git clone https://github.com/johannescalvin/common-mark-extensions.git
cd common-mark-extensions/link-acessability-validator
mvn assembly:assembly
sudo mkdir ~/executable-jars
sudo mv target/target/link-acessability-validator-1.0-SNAPSHOT-jar-with-dependencies.jar ~/executable-jars/
sudo cp scripts/url-access-validate ~/executable-jars/
sudo ln -s /usr/bin/url-access-validate ~/executable-jars/url-access-validate
```

## 集成到Git项目中

首先，需要进入git项目目录,然后

```bash
    cd .git/hooks
    curl -O https://raw.githubusercontent.com/johannescalvin/common-mark-extensions/master/link-acessability-validator/scripts/pre-commit
```

如此，就能在`git add`之后，`git commit`之前，对暂存区的markdown文件进行有效性检测。一旦发现无效链接，则中止提交，并且将触发问题的文档移出暂存区。
