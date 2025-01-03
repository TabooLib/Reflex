package org.tabooproject.reflex.asm

import org.tabooproject.reflex.ClassAnnotation
import org.tabooproject.reflex.Internal
import org.tabooproject.reflex.LazyClass
import org.tabooproject.reflex.serializer.BinaryWriter

/**
 * @author 坏黑
 * @since 2022/1/24 8:48 PM
 */
@Internal
class AsmAnnotation(source: LazyClass, val propertyMap: MutableMap<String, Any>) : ClassAnnotation(source) {

    constructor(annotationVisitor: AsmClassAnnotationVisitor) : this(annotationVisitor.source, annotationVisitor.propertyMap)

    @Suppress("UNCHECKED_CAST")
    override fun <T> property(name: String): T? {
        return propertyMap[name] as? T?
    }

    override fun <T> property(name: String, def: T): T {
        return property(name) ?: def
    }

    override fun properties(): Map<String, Any> {
        return propertyMap
    }

    override fun propertyKeys(): Set<String> {
        return propertyMap.keys
    }

    override fun toString(): String {
        return "AsmAnnotation() ${super.toString()}"
    }

    override fun writeTo(writer: BinaryWriter) {
        writer.writeObj(source)
        writer.writeAnnotationProperties(propertyMap)
    }

    companion object {

        private val internalMethods = arrayOf("equals", "hashCode", "toString")
    }
}