package it.sintra.user.utility;

public enum Message {


	MAIL_ALREADY_EXIST("The mail is used by another user."),
	FISCAL_CODE_EXIST("The fiscal code is used by another user"),
	IMAGE_IS_CORRUPT("The identity card image is corrupt"),
	HASH_IS_CORRUPT("The hash input is corrupt"),
	USER_NOT_FOUND("User resource not found of database system."),
	DELETE_USER_NOT_FOUND("It's not possible to delete the resourc user because it is not present on the database sustem"),
	ERROR_CHECK_IMAGE("Internal server error could not check identity of the card image"),
	INTERNAL_SERVER_ERROR("Internal Server error.");


	private final String text;

    /**
     * @param text
     */
	Message(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }	
	
}