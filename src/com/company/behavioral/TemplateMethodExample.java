package com.company.behavioral;

//TemplateMethod
abstract class AbstractStory {
    protected abstract String describePlot();
    protected abstract String describeConflict();
    protected abstract String describeResolution();
    public void showStory() {
        System.out.println(describePlot());
        System.out.println(describeConflict());
        System.out.println(describeResolution());
    }
}
class FootballStory extends AbstractStory {
    @Override
    protected String describePlot() {
        return "Football plot";
    }
    @Override
    protected String describeConflict() {
        return "Football conflict";
    }
    @Override
    protected String describeResolution() {
        return "Football resolution";
    }
}
class LifeStory extends AbstractStory {
    @Override
    protected String describePlot() {
        return "Life plot";
    }
    @Override
    protected String describeConflict() {
        return "Life conflict";
    }
    @Override
    protected String describeResolution() {
        return "Life resolution";
    }
}
public class TemplateMethodExample {
    public static void main(String[] args) {
        AbstractStory story1 = new FootballStory();
        story1.showStory();

        System.out.println();

        AbstractStory story2 = new LifeStory();
        story2.showStory();
    }
}
