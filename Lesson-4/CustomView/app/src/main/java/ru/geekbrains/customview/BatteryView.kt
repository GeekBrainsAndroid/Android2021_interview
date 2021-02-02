package ru.geekbrains.customview

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

// Кастомный пользовательский элемент
// Нарисуем батарею
class BatteryView : View {
    // Цвет батареи
    private var batteryColor = Color.GRAY

    // Цвет уровня заряда
    private var levelColor = Color.GREEN

    // Изображение батареи
    private val batteryRectangle = RectF()

    // Изображение уровня заряда
    private val levelRectangle = Rect()

    // Изображение головы батареи
    private val headRectangle = Rect()

    // "Краска" батареи
    private lateinit var batteryPaint: Paint

    // "Краска" заряда
    private lateinit var levelPaint: Paint

    // Ширина элемента
    private var batteryWidth = 0

    // Высота элемента
    private var batteryHeight = 0

    // Уровень заряда
    private var level = 100

    constructor(context: Context?) : super(context) {
        init()
    }

    // Вызывается при добавлении элемента в макет
    // AttributeSet attrs - набор параметров, указанных в макете для этого элемента
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
        initAttr(context, attrs)
        init()
    }

    // Вызывается при добавлении элемента в макет с установленными стилями
    // AttributeSet attrs - набор параметров, указанных в макете для этого элемента
    // int defStyleAttr - базовый установленный стиль
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        initAttr(context, attrs)
        init()
    }

    // Вызывается при добавлении элемента в макет с установленными стилями
    // AttributeSet attrs - набор параметров, указанных в макете для этого элемента
    // int defStyleAttr - базовый установленный стиль
    // int defStyleRes - ресурс стиля, если он не был определен в предыдущем параметре
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initAttr(context, attrs)
        init()
    }

    // Инициализация атрибутов пользовательского элемента из xml
    private fun initAttr(
        context: Context,
        attrs: AttributeSet?
    ) {
        with(context.obtainStyledAttributes(attrs, R.styleable.BatteryView, 0, 0)) {

            // Чтобы получить какое-либо значение из этого массива,
            // надо вызвать соответсвующий метод, и передав в этот метод имя ресурса
            // указанного в файле определения атрибутов (attrs.xml)
            batteryColor =
                getColor(R.styleable.BatteryView_battery_color, Color.GRAY)

            // вторым параметром идет значение по умолчанию, если атрибут не указан в макете,
            // то будет подставлятся эначение по умолчанию.
            levelColor =
                getColor(R.styleable.BatteryView_level_color, Color.GREEN)

            // Обратите внимание, что первый параметр пишется особым способом
            // через подчерки. первое слово означает имя определения
            // <declare-styleable name="BatteryView">
            // следующее слово имя атрибута
            // <attr name="level" format="integer" />
            level = getInteger(R.styleable.BatteryView_level, 100)

            // В конце работы дадим сигнал,
            // что нам больше массив со значениями атрибутов не нужен
            // Система в дальнейшем будет переиспользовать этот объект,
            // и мы никогда не получим к нему доступ из этого элемента
            recycle()
        }
    }

    // Начальная инициализация полей класса
    private fun init() {
        batteryPaint = Paint().run {
            color = batteryColor
            style = Paint.Style.FILL
            this
        }

        levelPaint = Paint().run {
            color = levelColor
            style = Paint.Style.FILL
            this
        }

    }

    // Когда система Андроид создает пользовательский экран, то еще неизвестны размеры элемента.
    // Это связанно с тем, что используются расчетные единица измерения,
    // то есть, чтобы элемент выглядил одинаково на разных усройствах,
    // необходимы расчеты размера элемента, в привязке к размеру экрана, его разрешения и плотности пикселей.
    // Этот метод вызывается при необходимости изменения размера элемента
    // Такая необходимость возникает каждый раз при отрисовке экрана.
    // Если нам надо нарисовать свой элемент, то переопределяем этот метод,
    // и задаем новые размеры нашим элементам внутри view
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        // Получить реальные ширину и высоту
        batteryWidth = w - paddingLeft - paddingRight
        batteryHeight = h - paddingTop - paddingBottom
        // Отрисовка батареи
        batteryRectangle[padding.toFloat(), padding.toFloat(), batteryWidth - padding - headWidth.toFloat()] =
            batteryHeight - padding.toFloat()
        headRectangle[width - padding - headWidth, 2 * padding, batteryWidth - padding] =
            batteryHeight - 2 * padding
        levelRectangle[2 * padding, 2 * padding, ((width - 2 * padding - headWidth) * (level.toDouble() / 100.toDouble())).toInt()] =
            batteryHeight - 2 * padding
    }

    // Вызывается, когда надо нарисовать элемент
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        with(canvas) {
            drawRoundRect(
                batteryRectangle,
                round.toFloat(),
                round.toFloat(),
                batteryPaint
            )
            drawRect(levelRectangle, levelPaint)
            drawRect(headRectangle, batteryPaint)
        }
    }

    companion object {
        // Константы
        // Отступ элементов
        private const val padding = 10

        // Скругление углов батареи
        private const val round = 5

        // Ширина головы батареи
        private const val headWidth = 10
    }
}
