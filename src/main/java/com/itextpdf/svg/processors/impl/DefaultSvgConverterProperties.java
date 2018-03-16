package com.itextpdf.svg.processors.impl;

import com.itextpdf.styledxmlparser.css.ICssResolver;
import com.itextpdf.styledxmlparser.node.INode;
import com.itextpdf.svg.css.impl.DefaultSvgStyleResolver;
import com.itextpdf.svg.processors.ISvgConverterProperties;
import com.itextpdf.svg.renderers.factories.DefaultSvgNodeRendererFactory;
import com.itextpdf.svg.renderers.factories.ISvgNodeRendererFactory;
import java.nio.charset.StandardCharsets;

/**
 * Default and fallback implementation of {@link ISvgConverterProperties} for
 * {@link DefaultSvgProcessor}
 */
public class DefaultSvgConverterProperties implements ISvgConverterProperties {

    private ICssResolver cssResolver;
    private ISvgNodeRendererFactory rendererFactory;

    public DefaultSvgConverterProperties(INode root) {
        cssResolver = new DefaultSvgStyleResolver(root);
        rendererFactory = new DefaultSvgNodeRendererFactory();
    }

    @Override
    public ICssResolver getCssResolver() {
        return cssResolver;
    }

    @Override
    public ISvgNodeRendererFactory getRendererFactory() {
        return rendererFactory;
    }

    @Override
    public String getCharset() {
        // may also return null, but null will always default to UTF-8 in JSoup
        return StandardCharsets.UTF_8.name();
    }
}
