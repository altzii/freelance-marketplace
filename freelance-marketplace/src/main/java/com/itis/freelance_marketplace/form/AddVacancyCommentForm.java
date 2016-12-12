package com.itis.freelance_marketplace.form;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by alt on 13.12.16.
 */
public class AddVacancyCommentForm {
    @NotEmpty(message = "Текст комментария не должен быть пустым")
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
