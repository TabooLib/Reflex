package org.tabooproject.reflex.res

/**
 * TabooLib
 * org.tabooproject.reflex.res.EventPriority
 *
 * @author sky
 * @since 2021/6/16 1:07 上午
 */
enum class EventPriority(val level: Int) {

    LOWEST(-64), LOW(-32), NORMAL(0), HIGH(32), HIGHEST(64), MONITOR(128)
}