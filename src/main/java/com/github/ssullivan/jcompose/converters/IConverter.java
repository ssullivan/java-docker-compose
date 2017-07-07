package com.github.ssullivan.jcompose.converters;

/**
 * Created by catal on 7/6/2017.
 */
public interface IConverter<FROM, TO> {
    TO convert(FROM from);
}
