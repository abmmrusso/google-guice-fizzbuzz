package net.toryu.playground.guice;

class DummyNumberTranslator implements NumberTranslator {

    public static final String TRANSLATION_PREFIX = "translated-";

    @Override
    public String translate(int numberToTranslate) {
        return TRANSLATION_PREFIX + numberToTranslate;
    }
}
