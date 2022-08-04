package com.leb.jet.modules.test

import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.FragmentActivity
import com.leb.jet.R
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlin.coroutines.suspendCoroutine
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class TestCoroutineActivity :FragmentActivity(){

    val mScope = CoroutineScope(Dispatchers.Default);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_coroutine);

        findViewById<ImageView>(R.id.backIv).setOnClickListener { finish() }
        test();
    }

    fun test () {
        //TODO 总结从普通方法调用suspend方法的使用
        mScope.launch {
            testComposeFun();
            testFlow()
        }
    }

    private suspend fun testComposeFun() {
        //组合挂起函数。默认顺序调用。
        //测量两个挂起函数执行的时间
        val time = measureTimeMillis {
            val one = doSomethingUsefulOne();
            println("complete first fun .$one")
            val two = doSomethingUsefulTwo();
            println("The answer is ${one + two}");
        }
        println("Completed in $time ms")

        //使用async并发
        println("-------使用async并发------");
        val time2 = measureTimeMillis {
//            val one = CoroutineScope.async {
//
//            }
            val scope = coroutineScope {
                val one = async {
                    doSomethingUsefulOne();
                }
                val two = async {
                    doSomethingUsefulTwo();
                }
                println("The Answer is ${one.await() + two.await()}")
            }
        }
        println("Complete in time:$time2");

        println("-----惰性启动async--------")
        val time3 = measureTimeMillis {
            val scope3 = coroutineScope {
                val one = async(start = CoroutineStart.LAZY) {
                    doSomethingUsefulOne();
                }
                val two = async(start = CoroutineStart.LAZY) {
                    doSomethingUsefulTwo();
                }
                one.start();
                two.start();
                println("The Answer is ${one.await() + two.await()}")
            }
        }
        println("Complete in time:$time3");
    }

    private suspend fun doSomethingUsefulOne():Int {
        delay(1000L);
        return 29;
    }

    private suspend fun doSomethingUsefulTwo():Int {
        delay(1000L);
        return  20;
    }

    private suspend fun testFlow() {
        print("------测试------")
        (1..5).asFlow().filter {
            println("Filter $it")
            it % 2 == 0
        }.map {
            println("Map $it")
            "String $it"
        }.collect() {
            println("Collect $it")
        }
    }
}