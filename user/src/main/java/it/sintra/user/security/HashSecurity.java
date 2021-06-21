package it.sintra.user.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.util.encoders.Hex;

import it.sintra.user.common.exception.CorruptImageException;
import it.sintra.user.utility.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HashSecurity {

	public static String generateCardImageHash(String input) {

		byte[] bytesOfMessage;
		try {
			bytesOfMessage = input.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {

			log.debug(e.getMessage(), e);
			throw new CorruptImageException(Message.ERROR_CHECK_IMAGE.toString());

		}

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			input.getBytes(StandardCharsets.UTF_8);

			byte[] thedigest = digest.digest(bytesOfMessage);
			return Hex.toHexString(thedigest);
		} catch (NoSuchAlgorithmException e) {
			log.debug(e.getMessage(), e);
			throw new CorruptImageException(Message.ERROR_CHECK_IMAGE.toString());
		}

	}
}
