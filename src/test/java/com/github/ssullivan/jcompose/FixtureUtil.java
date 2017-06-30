package com.github.ssullivan.jcompose;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;

import java.io.IOException;

/**
 * Created by catal on 6/29/2017.
 */
public class FixtureUtil {

    private FixtureUtil() {
        // Prevent instantiation
    }

    public static String fixture(final String filename) throws IOException {
        return Resources.toString(Resources.getResource(filename), Charsets.UTF_8).trim();
    }
}
