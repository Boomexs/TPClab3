package eu.jpereira.trainings.designpatterns.structural.decorator;

import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelProperties;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.SocialChannelPropertyKey;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.AbstractSocialChanneldDecoratorTest;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.MessageTruncator;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.URLAppender;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator.WordCensor;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.dummy.DummySocialChannelBuilder;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.spy.TestSpySocialChannel;
import eu.jpereira.trainings.designpatterns.structural.decorator.channel.*;
import org.junit.Test;

public class ChainCensorDecoratorTest extends AbstractSocialChanneldDecoratorTest {
    @Test
    public void testChainCensorDecorator() {
        SocialChannelBuilder builder = createTestSpySocialChannelBuilder();

        SocialChannelProperties properties = new SocialChannelProperties()
                .putProperty(SocialChannelPropertyKey.NAME, TestSpySocialChannel.NAME);

        SocialChannel channel = builder
                .with(new WordCensor())
                .with(new MessageTruncator(50))
                .with(new URLAppender("https://www.google.com/"))
                .getDecoratedChannel(properties);

        channel.deliverMessage("censorme help.");
        TestSpySocialChannel testSpySocialChannel = (TestSpySocialChannel) builder.buildChannel(properties);

        assert("### help. https://www.google.com/".equals(testSpySocialChannel.lastMessagePublished()));
    }
}
