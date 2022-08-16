该示例程序用来展示Android开发中，一些功能的使用方法及其介绍。

目前包含如下点：





# Category
## View
##### 

## Kotlin
#### Kotlin Flow 与LiveData
    [codelab](https://developer.android.google.cn/codelabs/advanced-kotlin-coroutines#0)

## package or feature
#### ViewBinding

#### DataBinding

#### 生命周期感知型组件
##### 1、Lifecycle(jetpack)
    生命周期感知型组件的最佳做法
        使界面控制器（Activity 和 Fragment）尽可能保持精简。它们不应试图获取自己的数据，而应使用 ViewModel 执行此操作，并观察 LiveData 对象以将更改体现到视图中。
        设法编写数据驱动型界面，对于此类界面，界面控制器的责任是随着数据更改而更新视图，或者将用户操作通知给 ViewModel。
        将数据逻辑放在 ViewModel 类中。ViewModel 应充当界面控制器与应用其余部分之间的连接器。不过要注意，ViewModel 不负责获取数据（例如，从网络获取）。但是，ViewModel 应调用相应的组件来获取数据，然后将结果提供给界面控制器。
        使用数据绑定在视图与界面控制器之间维持干净的接口。这样一来，您可以使视图更具声明性，并尽量减少需要在 Activity 和 Fragment 中编写的更新代码。如果您更愿意使用 Java 编程语言执行此操作，请使用诸如 Butter Knife 之类的库，以避免样板代码并实现更好的抽象化。
        如果界面很复杂，不妨考虑创建 presenter 类来处理界面的修改。这可能是一项艰巨的任务，但这样做可使界面组件更易于测试。
        避免在 ViewModel 中引用 View 或 Activity 上下文。如果 ViewModel 存在的时间比 activity 更长（在配置更改的情况下），activity 将泄漏并且不会获得垃圾回收器的妥善处置。
        使用 Kotlin 协程管理长时间运行的任务和其他可以异步运行的操作
    处理 ON_STOP 事件

##### ViewModel(jetpack)
    旨在以注重生命周期的方式存储和管理界面相关的数据
    
    TODO 将协程与ViewModel一起使用

###### 注意：
    1、：ViewModel 绝不能引用视图、Lifecycle 或可能存储对 Activity 上下文的引用的任何类。

##### LiveData(jetpack)
    [官方文档](https://developer.android.google.cn/topic/libraries/architecture/livedata)

#### WorkManager
#### Padding
#### Compose
    1、可组合函数
    
# 常见问题
    1、数据绑定BR找不到
        需要在builg.gralde中增加kotlin的插件
        id 'kotlin-kapt'
    2、Kotlin直接使用控件id
        （1）在项目的build.gralde中添加
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version" 
        classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"
        （2）app下build.gradle
        //写法一
        plugins {
            id 'kotlin-android'
            id 'kotlin-android-extensions'
        }
        //写法二
        applyplugin:'kotlin-android'
        applyplugin:'kotlin-android-extensions' or 'kotlin-parcelize'

        (3) 页面中引入
        import kotlinx.android.synthetic.main.xxx.*


# 参考文章
    1、[数据绑定-经验教训](https://medium.com/androiddevelopers/data-binding-lessons-learnt-4fd16576b719)
    2、[MVP](https://www.gwtproject.org/articles/mvp-architecture.html#presenter)