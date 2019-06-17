# common-mark-extensions

本项目是在做[个人博客项目](https://github.com/johannescalvin/blog-system)的一个副产品。

## 整体概述

其中`link-acessability-validator`负责markdown文本的链接有效性检测。

`catalog-generator`负责根据markdown生成的html页面中的`<h>`标签生成目录，并与其组合之后，能够提供页内导航功能

`comment`负责解析markdown文档中的注释

相关博客

1. [为markdwon文件生成目录](http://blog.freecode.tech/yangchengzhu/blogsys/generate_catalog_of_markdown.html)
2. [markdown文件中的链接可达性检测](http://blog.freecode.tech/yangchengzhu/blogsys/accessability_detection_of_url_in_markdown.html)
3. [定制Markdown注释处理](http://blog.freecode.tech/yangchengzhu/blogsys/customize_comment_in_markdown.html)

## 在maven中使用

如果需要在maven项目中使用,均需要在`pom.xml`文件中加

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

然后加入相应依赖即可。


