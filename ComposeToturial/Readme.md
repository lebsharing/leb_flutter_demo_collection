#ComposeTutorial
    本项目是根据官方Compose教程，进行练习使用。
    官网教程地址：https://developer.android.com/jetpack/compose/tutorial

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

       可组合函数可以使用 remember API 将对象存储在内存中。系统会在初始组合期间将由 remember 计算的值存储在组合中，
    并在重组期间返回存储的值。remember 既可用于存储可变对象，又可用于存储不可变对象
    在可组合项中声明 MutableState 对象的方法有三种：
        val mutableState = remember { mutableStateOf(default) }
        var value by remember { mutableStateOf(default) }
        val (value, setValue) = remember { mutableStateOf(default) }
    这些声明是等效的，以语法糖的形式针对状态的不同用法提供。
        by 委托语法需要以下导入
        import androidx.compose.runtime.getValue
        import androidx.compose.runtime.setValue

    支持其他可观察类型管理状态。读取其他可观察类型之前，您必须将其转换为 State<T>，以便 Jetpack Compose 可以在状态发生变化时自动重组界面。
    常见的可观察类型：LiveData/Flow/RxJava2

    注意：
    （1）remember 函数仅在可组合项包含在组合中时起作用
    （2）虽然 remember 可帮助您在重组后保持状态，但不会帮助您在配置更改后保持状态。为此，您必须使用 rememberSaveable。
    rememberSaveable 会自动保存可保存在 Bundle 中的任何值。对于其他值，您可以将其传入自定义 Saver 对象。

    3、生命周期

    4、Compose 修饰符
    使用修饰符来执行以下操作：
        ·更改可组合项的大小、布局、行为和外观
        ·添加信息，如无障碍标签
        ·处理用户输入
        ·添加高级互动，如使元素可点击、可滚动、可拖动或可缩放
    
    使用Modifier类函数创建修饰符

    修饰符顺序很重要
    由于每个函数都会对上一个函数返回的 Modifier 进行更改，因此顺序会影响最终结果

    注意：
    明确的顺序可帮助您推断不同的修饰符将如何相互作用。您可以将这一点与基于视图的系统进行比较。在基于视图的系统中，
    您必须了解框模型，在这种模型中，在元素的“外部”应用外边距，而在元素的“内部”应用内边距，并且背景元素将相应地调整大小。
    修饰符设计使这种行为变得明确且可预测，并且可让您更好地进行控制，以实现您期望的确切行为。这也说明了为什么没有外边距修饰符，而只有 padding 修饰符。
    
    内置修饰符
        Modifier.size(width = 400.dp, height = 100.dp)/
        Modifier.requiredSize(150.dp)
        Modifier.fillMaxHeight()
    偏移量 Modifier.offset(x = 4.dp)
    
    5、Compose中的附带效应
    (官方文档)[https://developer.android.com/jetpack/compose/side-effects]
    
    LaunchedEffect：在某个可组合项的作用域内运行挂起函数
    rememberCoroutineScope：获取组合感知作用域，以便在可组合项外启动协程
    rememberUpdatedState：在效应中引用某个值，该效应在值改变时不应重启
    DisposableEffect：需要清理的效应
    SideEffect：将 Compose 状态发布为非 Compose 代码
    produceState：将非 Compose 状态转换为 Compose 状态
    derivedStateOf：将一个或多个状态对象转换为其他状态
    snapshotFlow：将 Compose 的 State 转换为 Flow
    ....

    6、阶段/绘制
    ()[https://developer.android.com/jetpack/compose/phases]

    7、架构分层
    (架构分层)[https://developer.android.com/jetpack/compose/layering]

    8、CompositionLocal

