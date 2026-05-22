package designpattern.coreJava.behavioralpattern.statepattern;

import designpattern.coreJava.behavioralpattern.statepattern.state.DocumentState;
import designpattern.coreJava.behavioralpattern.statepattern.state.DraftDocumentState;

public class Document {
    private DocumentState currentState;
    private DocumentDetail documentDetail;

    public Document() {
        this.currentState = new DraftDocumentState();
    }

    public void setCurrentState(DocumentState currentState) {
        this.currentState = currentState;
    }

    public void edit(DocumentDetail documentDetail) {
        this.documentDetail = documentDetail;
        currentState.edit(this);
    }

    public void publish() {
        currentState.publish(this);
    }

    public DocumentDetail getDocumentDetail() {
        return documentDetail;
    }

}
