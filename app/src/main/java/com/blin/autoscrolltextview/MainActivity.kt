package com.blin.autoscrolltextview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blin.autoscrolltextview.databinding.ActivityMainBinding
import com.blin.haililibrary.AutoScrollTextView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun resetText(view: View) {
        findViewById<AutoScrollTextView>(R.id.tv_robot_content).setAutoText(txt)
    }


    val txt ="《三国演义》是一部中国古典小说，全书共120回。小说主要描写了从东汉末年到三国时期的历史故事，包括了著名的三国英雄关羽、张飞、赵云、马超、黄忠、吕布、曹操、刘备、孙权、诸葛亮等人的传奇故事。\n" +
            "\n" +
            "小说通过讲述这些人物之间的政治斗争、军事战争、文化交流等方面的内容，展示了三国时期的历史风貌和人物形象，同时也反映了中国古代社会的政治文化和道德观念。\n" +
            "\n" +
            "小说以东汉末年黄巾起义为开端，讲述了汉献帝时期宦官专权和外戚势力的斗争，以及曹操、刘备、孙权等人的崛起和争霸过程。其中，曹操是三国时期最具代表性的政治家和军事家之一，他在小说中被描绘成一个谋略高超、兵法精湛的人物。刘备则是一个仁义之君的形象，他和关羽、张飞等人一起建立了蜀汉政权。孙权则是吴国开国皇帝，他在小说中被描绘成一个足智多谋、善于用人的人物。\n" +
            "\n" +
            "除了这些主要人物外，小说中还有许多其他英雄人物的故事，如吕布、貂蝉、华佗等等。其中吕布是一个有着复杂性格的人物，他既是一位勇猛无比的武将，也是一个心胸狭窄、不识大体的人。而貂蝉则是一个美丽动人的女子，她在小说中被描绘成一个巧妙运用美色和机智的人物。\n" +
            "\n" +
            "总之，《三国演义》是一部具有深厚历史文化底蕴的经典小说，"
}