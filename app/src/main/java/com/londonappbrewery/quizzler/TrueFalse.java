package com.londonappbrewery.quizzler;



public class TrueFalse {

    private int questionId;
    private boolean answer;

    public TrueFalse(int qresourceId,boolean TrueorFalse){

        questionId = qresourceId;
        answer = TrueorFalse;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}

