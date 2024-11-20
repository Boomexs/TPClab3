package eu.jpereira.trainings.designpatterns.structural.decorator.channel.decorator;

public class WordCensor extends SocialChannelDecorator {


    @Override
    public void deliverMessage(String message) {
        if(delegate != null) {
            String censoredMSG = censorWords(message);
            delegate.deliverMessage(censoredMSG);
        }
    }

    private String censorWords(String message){
        return message.replaceAll("(?i)censorme", "###"); // (?i) is placed at the beginning of the regex pattern to make the entire pattern case-insensitive. ~stackoverflow
    }
}
