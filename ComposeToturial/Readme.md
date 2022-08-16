#ComposeTutorial
    本项目是根据官方Compose教程，进行练习使用。
    官网教程地址：https://developer.android.com/jetpack/compose/tutorial
    
    branch说明：
    【main】官网教程地址：https://developer.android.com/jetpack/compose/tutorial
    【baseCompose】:官网教程：https://developer.android.com/courses/pathways/compose

#### Compose编程思想
    官网文档：https://developer.android.com/jetpack/compose/mental-model?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fcompose%23article-https%3A%2F%2Fdeveloper.android.com%2Fjetpack%2Fcompose%2Fmental-model
    
    声明性编程范式
    重组

#### Compose集成到项目中
    参考文章：[https://developer.android.com/jetpack/compose/setup]
    
    添加Jetpack Compose 工具包依赖项
        每一个依赖包的版本，可以从官网查询最新的依赖版本
    dependencies {
        implementation("androidx.compose.ui:ui:1.1.1")
        // Tooling support (Previews, etc.)
        implementation("androidx.compose.ui:ui-tooling:1.1.1")
        // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
        implementation("androidx.compose.foundation:foundation:1.1.1")
        // Material Design
        implementation("androidx.compose.material:material:1.1.1")
        // Material design icons
        implementation("androidx.compose.material:material-icons-core:1.1.1")
        implementation("androidx.compose.material:material-icons-extended:1.1.1")
        // Integration with observables
        implementation("androidx.compose.runtime:runtime-livedata:1.1.1")
        implementation("androidx.compose.runtime:runtime-rxjava2:1.1.1")

        // UI Tests
        androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.1.1")
    }

    1、创建支持Jetpack Compose的新应用
        a、AS从菜单栏中选择File > New > New Project
        b、从Select a Project Template窗口中，选择Empty Compose Activity,然后点击Next
        c、在Configure your project中，配置项目
        d、点击Finish.
        e、根据[添加Jetpack Compose 工具包依赖项] 中所述，验证项目的build.gradle文件配置是否正确
    
    2、将Jetpack Compose添加到现有的项目中
        根据[添加Jetpack Compose 工具包依赖项] 中所述，将Jetpack Compse添加到应用

#### 使用入门
    1、可组合函数
    可组合函数是带有@Composable注解的常规函数。这类函数可以掉用其他常规函数。
    @Composable
    private fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }
    
    2、状态管理
    (官方文档)[https://developer.android.com/jetpack/compose/state?hl=zh-cn]
    remember/rememberSaveable/

    注意：
    remember 函数仅在可组合项包含在组合中时起作用