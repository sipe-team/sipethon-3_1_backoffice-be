package team.sipe.office.modules.faq.infrastructure.persistence;

import jakarta.persistence.*;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Table(name = "faqs")
@Entity
public class FaqEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Comment("기간")
    @Column(name = "term", nullable = false)
    private long term;

    @Comment("질문")
    @Column(name = "question", nullable = false)
    private String question;

    @Comment("답변")
    @Column(name = "answer", nullable = false)
    private String answer;

    public FaqEntity() {
    }

    public FaqEntity(final Long seq, final long term, final String question, final String answer) {
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
        final FaqEntity faqEntity = (FaqEntity) o;
        return Objects.equals(getSeq(), faqEntity.getSeq());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getSeq());
    }
}
