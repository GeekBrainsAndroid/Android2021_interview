package ru.geekbrains.srp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.lang.Integer.min
import kotlin.math.PI

class Circle : View {

    private lateinit var circlePaint: Paint
    private var circleColor = Color.GREEN
    var radius: Int = 0
    private var centerX: Int = 0
    private var centerY: Int = 0

    constructor(context: Context) : super(context){
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){
        initializeAttr(context, attrs)
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initializeAttr(context, attrs)
        initialize()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes){
        initializeAttr(context, attrs)
        initialize()
    }

    private fun initialize(){
        circlePaint = Paint()
        circlePaint.color = circleColor
        circlePaint.style = Paint.Style.FILL
    }

    // Инициализация атрибутов пользовательского элемента из xml
    private fun initializeAttr(
        context: Context,
        attrs: AttributeSet
    ) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.Circle, 0, 0)
        circleColor = typedArray.getColor(R.styleable.Circle_color, Color.GREEN)
        typedArray.recycle()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // Получить реальные ширину и высоту
        val widthView = w - paddingLeft - paddingRight
        val heightView = h - paddingTop - paddingBottom
        radius = min(widthView, heightView) / 2
        centerX = w / 2
        centerY = h / 2
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(centerX.toFloat(), centerY.toFloat(), radius.toFloat(), circlePaint)
    }

    val area: Double
        get() {
            return PI * radius * radius
        }
}