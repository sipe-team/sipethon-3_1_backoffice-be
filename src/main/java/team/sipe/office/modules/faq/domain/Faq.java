package team.sipe.office.modules.faq.domain;

import java.util.Objects;

public class Faq {

    private Long seq;
    private long term;
    private String question;
    private String answer;

    public static Faq init(final long term, final String question, final String answer) {
        return new Faq(null, term, question, answer);
    }

    public Faq(final Long seq, final long term, final String question, final String answer) {
        this.seq = seq;
        this.term = term;
        this.question = question;
        this.answer = answer;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(final Long seq) {
        this.seq = seq;
    }

    public long getTerm() {
        return term;
    }

    public void setTerm(final long term) {
        this.term = term;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(final String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(final String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Faq faq = (Faq) o;
        return Objects.equals(getSeq(), faq.getSeq());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSeq());
    }
}
