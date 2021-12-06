package com.springboot.admin.common.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * RSA 工具类。提供加密，解密，生成密钥对等方法。
 *
 * @author 骏
 */
@Slf4j
public class RSAUtil {

    /**
     * 算法名称
     */
    private static final String ALGORITHM = "RSA";
    /**
     * 默认的安全服务提供者
     */
    private static final Provider DEFAULT_PROVIDER = new BouncyCastleProvider();
    /**
     * 密钥大小
     */
    private static final int KEY_SIZE = 1024;

    /**
     * 生成密钥对
     * 返回的是私钥对的Object的Map
     *
     * @return 私钥对的Object的Map
     * {<br>
     * "publicKey" : 公钥,<br>
     * "privateKey" : 私钥<br>
     * }
     */
//	public static Map<String, Object> generateKeyPairMap() {
//		Map<String, Object> resultMap = null;
//		try {
//			resultMap = new HashMap<>();
//			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM, new BouncyCastleProvider());
//			// 设置秘钥大小和随机源
//			keyPairGen.initialize(KEY_SIZE, new SecureRandom());
//			// 获得秘钥对
//			KeyPair keyPair = keyPairGen.generateKeyPair();
//
//			// 获得公钥
//			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//			// 获得私钥
//			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//
//			// 存入Map
//			resultMap.put("publicKey", publicKey);
//			resultMap.put("privateKey", privateKey);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return resultMap;
//	}
//
//	/**
//	 * 生成密钥对
//	 * 返回的是秘钥对的BigInteger型特征值Map
//	 *
//	 * @return 秘钥对的特征值Map {<br>
//	 * "modulus" : 模,<br>
//	 * "publicExponent" : 公钥指数,<br>
//	 * "privateExponent" : 私钥指数<br>
//	 * }
//	 */
//	public static Map<String, BigInteger> generateKeyPairEigenMap() {
//		Map<String, BigInteger> resultMap = null;
//		try {
//			resultMap = new HashMap<>();
//			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(ALGORITHM, new BouncyCastleProvider());
//			// 设置秘钥大小和随机源
//			keyPairGen.initialize(KEY_SIZE, new SecureRandom());
//			// 获得秘钥对
//			KeyPair keyPair = keyPairGen.generateKeyPair();
//
//			// 获得公钥
//			RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
//			// 获得私钥
//			RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
//
//			// 获得模
//			BigInteger modulus = publicKey.getModulus();
//			// 获得公钥指数
//			BigInteger publicExponent = publicKey.getPublicExponent();
//			// 获得私钥指数
//			BigInteger privateExponent = privateKey.getPrivateExponent();
//
//			// 存入Map
//			resultMap.put("modulus", modulus);
//			resultMap.put("publicExponent", publicExponent);
//			resultMap.put("privateExponent", privateExponent);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return resultMap;
//	}

    /**
     * 通过模和指数生成公钥
     *
     * @param modulus        模
     * @param publicExponent 公钥指数
     * @return RSAPublicKey *
     * @throws Exception
     */
    public static RSAPublicKey generateRSAPublicKey(BigInteger modulus, BigInteger publicExponent) throws GeneralSecurityException {
        KeyFactory keyFac;
        keyFac = KeyFactory.getInstance(ALGORITHM, new BouncyCastleProvider());
        RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
        return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
    }

    /**
     * 通过模和指数生成私钥
     *
     * @param modulus         模
     * @param privateExponent 公钥指数
     * @return RSAPrivateKey *
     * @throws Exception
     */
    public static RSAPrivateKey generateRSAPrivateKey(BigInteger modulus, BigInteger privateExponent) throws GeneralSecurityException {
        KeyFactory keyFac;
        keyFac = KeyFactory.getInstance(ALGORITHM, new BouncyCastleProvider());
        RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(modulus, privateExponent);
        return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);
    }

    // XXX 明文过长时的分块加密
    //	/**
    //	 * 加密
    //	 *
    //	 * @param pk	加密的密钥
    //	 * @param data	待加密的明文数据
    //	 * @return 加密后的数据
    //	 * @throws Exception
    //	 */
    //	public static byte[] encrypt(PublicKey pk, byte[] data) throws Exception {
    //		try {
    //			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
    //			cipher.init(Cipher.ENCRYPT_MODE, pk);
    //			// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
    //			int blockSize = cipher.getBlockSize();
    //			// 加密块大小为127
    //			// byte,加密后为128个byte;因此共有2个加密块，第一个127
    //			// byte第二个为1个byte
    //			int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
    //			int leavedSize = data.length % blockSize;
    //			int blocksSize = leavedSize != 0 ? data.length / blockSize + 1 : data.length / blockSize;
    //			byte[] raw = new byte[outputSize * blocksSize];
    //			int i = 0;
    //			while (data.length - i * blockSize > 0) {
    //				if (data.length - i * blockSize > blockSize) {
    //					cipher.doFinal(data, i * blockSize, blockSize, raw, i * outputSize);
    //				} else {
    //					cipher.doFinal(data, i * blockSize, data.length - i * blockSize, raw, i * outputSize);
    //				}
    //				i++;
    //			}
    //			return raw;
    //		} catch (Exception e) {
    //			throw new Exception(e.getMessage());
    //		}
    //	}
    //
    //	/**
    //	 * 解密
    //	 *
    //	 * @param pk	解密的密钥
    //	 * @param raw	已经加密的数据
    //	 * @return 解密后的明文
    //	 * @throws Exception
    //	 */
    //	@SuppressWarnings("static-access")
    //	public static byte[] decrypt(PrivateKey pk, byte[] raw) throws Exception {
    //		try {
    //			Cipher cipher = Cipher.getInstance("RSA", new org.bouncycastle.jce.provider.BouncyCastleProvider());
    //			cipher.init(cipher.DECRYPT_MODE, pk);
    //			int blockSize = cipher.getBlockSize();
    //			ByteArrayOutputStream bout = new ByteArrayOutputStream(64);
    //			int j = 0;
    //			while (raw.length - j * blockSize > 0) {
    //				bout.write(cipher.doFinal(raw, j * blockSize, blockSize));
    //				j++;
    //			}
    //			return bout.toByteArray();
    //		} catch (Exception e) {
    //			throw new Exception(e.getMessage());
    //		}
    //	}

    /**
     * 使用指定的公钥加密数据。
     *
     * @param publicKey 给定的公钥。
     * @param data      要加密的数据。
     * @return 加密后的数据。
     */
    public static byte[] encrypt(PublicKey publicKey, byte[] data) throws GeneralSecurityException {
        Cipher ci = Cipher.getInstance(ALGORITHM, DEFAULT_PROVIDER);
        ci.init(Cipher.ENCRYPT_MODE, publicKey);
        return ci.doFinal(data);
    }

    /**
     * 使用指定的私钥解密数据。
     *
     * @param privateKey 给定的私钥。
     * @param data       要解密的数据。
     * @return 原数据。
     */
    public static byte[] decrypt(PrivateKey privateKey, byte[] data) throws GeneralSecurityException {
        Cipher ci = Cipher.getInstance(ALGORITHM, DEFAULT_PROVIDER);
        ci.init(Cipher.DECRYPT_MODE, privateKey);
        return ci.doFinal(data);
    }

    /**
     * 使用给定的公钥加密给定的字符串。
     * <p/>
     * 若 {@code publicKey} 为 {@code null}，或者 {@code plaintext} 为 {@code null} 则返回 {@code
     * null}。
     *
     * @param publicKey 给定的公钥。
     * @param plaintext 字符串。
     * @return 给定字符串的密文。
     */
    public static String encryptString(PublicKey publicKey, String plaintext) {
        if (publicKey == null || plaintext == null) {
            return null;
        }
        try {
            byte[] data = plaintext.getBytes();
            byte[] en_data = encrypt(publicKey, data);
            return Hex.encodeHexString(en_data);
        } catch (GeneralSecurityException e) {
            log.error("私钥加密失败，{}", e.getMessage());
            return null;
        }
    }

    /**
     * 使用给定的私钥解密给定的字符串。
     * <p/>
     * 若私钥为 {@code null}，或者 {@code encrypttext} 为 {@code null}或空字符串则返回 {@code null}。
     * 私钥不匹配时，返回 {@code null}。
     *
     * @param privateKey  给定的私钥。
     * @param encrypttext 密文。
     * @return 原文字符串。
     */
    public static String decryptString(PrivateKey privateKey, String encrypttext) {
        if (privateKey == null || StringUtils.isBlank(encrypttext)) {
            return null;
        }
        try {
            byte[] en_data = Hex.decodeHex(encrypttext);
            byte[] data = decrypt(privateKey, en_data);
            return new String(data,"utf-8");
        } catch (DecoderException | GeneralSecurityException | UnsupportedEncodingException e) {
            log.error("私钥解密失败，{}", e.getMessage());
            return null;
        }
    }


/**
 * public static void main(String[] args) throws Exception {
 * <p>
 * // Long time_0 = System.currentTimeMillis();
 * // /*
 * //  * 1. 生成密钥对
 * //
 * // Map<String, BigInteger> kpMap = RSAUtil.generateKeyPairEigenMap();
 * // // 模 两端保存, 用于分别和公钥/私钥特征值组装公钥/私钥
 * // BigInteger modulus = kpMap.get("modulus");
 * // String modulus_hex = Hex.encodeToString(modulus.toByteArray());
 * // // 公钥特征值 公钥一般默认都为65537(10001), 客户端写死
 * // BigInteger publicExponent = kpMap.get("publicExponent");
 * // String publicExponent_hex = Hex.encodeToString(publicExponent.toByteArray());
 * // // 私钥特征值 移动端保存, 用于拼装私钥
 * // BigInteger privateExponent = kpMap.get("privateExponent");
 * // String privateExponent_hex = Hex.encodeToString(privateExponent.toByteArray());
 * //
 * // System.out.println("生成了新密钥对------------------------------------");
 * // System.out.println("模: " + modulus);
 * // System.out.println("模_HEX: " + modulus_hex);
 * // System.out.println("公钥特征值: " + publicExponent);
 * // System.out.println("公钥特征值_HEX: " + publicExponent_hex);
 * // System.out.println("私钥特征值: " + privateExponent);
 * // System.out.println("私钥特征值_HEX: " + privateExponent_hex);
 * // System.out.println("--------------------------------------------------");
 * // Long time_1 = System.currentTimeMillis();
 * // System.out.println("生成密钥对耗时: " + (time_1 - time_0) + " MS");
 * //
 * //
 * //  * 2. 加密
 * //
 * // String str = "[TEST]     这是明文";
 * // // 使用BASE64 编码以规避特殊字符
 * // String str_base64 = Base64.encodeToString(str.getBytes());
 * // // 使用模和公钥特征值拼装公钥
 * // PublicKey publicKey = RSAUtil.generateRSAPublicKey(modulus, publicExponent);
 * // // 加密密文
 * // String str_base64_en = RSAUtil.encryptString(publicKey, str_base64);
 * //
 * // System.out.println("加密----------------------------------------------");
 * // System.out.println("明文: " + str);
 * // System.out.println("BASE64编码: " + str_base64);
 * // System.out.println("密文: " + str_base64_en);
 * // System.out.println("--------------------------------------------------");
 * // Long time_2 = System.currentTimeMillis();
 * // System.out.println("加密耗时: " + (time_2 - time_1) + " MS");
 * //
 * //
 * //  * 3. 解密
 * //
 * // // 使用模和私钥特征值拼装私钥
 * // PrivateKey privateKey = RSAUtil.generateRSAPrivateKey(modulus, privateExponent);
 * // // 解密密文
 * // String str_base64_en_de = RSAUtil.decryptString(privateKey, str_base64_en);
 * // // BASE64 解码
 * // String str_base64_en_de_debase64 = Base64.decodeToString(str_base64_en_de);
 * //
 * // System.out.println("解密----------------------------------------------");
 * // System.out.println("解密后: " + str_base64_en_de);
 * // System.out.println("解码后: " + str_base64_en_de_debase64);
 * // System.out.println("--------------------------------------------------");
 * // Long time_3 = System.currentTimeMillis();
 * // System.out.println("解密耗时: " + (time_3 - time_2) + " MS");
 * <p>
 * <p>
 * // modulus: 133239000896223741574774106703227025391843821138048917394183797534820087374257952647810677158875437541588209263085220989249060369635957794458402029631250998682853888120220482234146399391102879694008496645755184467426297664802433683206205911258268070832283754202179272662518332545833756562111632825960287470709
 * // modulus_hex: 00bdbd1735d0bcee10681f4acf927d1f8a0f6dc79f5a542b30006c9bd35603f213ebabc5a6ce5f9e0f96e13afb4abf7d99706d1a5da268fd9a3c5bc59799d6b641bb68ef39a09a2ff5536115fb688f2f043d8e79206f6b4e459c2573bf8054b0c2aa993a9533ef3a64bf9a8ffc4edf544dcb5931dfe3cb5f8db6f1a21c93308475
 * // publicExponent: 65537
 * // publicExponent_hex: 010001
 * // privateExponent: 7378560923641526151975934580388360022920363176786022209275539962459481470166575565097388512879929220403804580905808353199687552093200830401468286609727129317426388272720408732865327212492031504537174627353565836399714130877312367270078675873457238393131297760481646897679890451976277495690071028209049608193
 * // privateExponent_hex: 0a81e63f275d79c6e97d3ccf5ca016970c0905a7b580e3c36217f6fe852242cdb2476e48068b15086d4ff121941f76a7d5ff5f6e6ab2c06decd9c834d50d7c44f489201aa51064f3a9ac81354995cd18b7afe6d22547eb5bb9151991dc30c110d7c4f215a0aadeb00b0aad47eac5f4a46d7d59299f56f8d172ed0550b9572001
 * <p>
 * <p>
 * String modulus = "133239000896223741574774106703227025391843821138048917394183797534820087374257952647810677158875437541588209263085220989249060369635957794458402029631250998682853888120220482234146399391102879694008496645755184467426297664802433683206205911258268070832283754202179272662518332545833756562111632825960287470709";
 * <p>
 * String privateExponent = "7378560923641526151975934580388360022920363176786022209275539962459481470166575565097388512879929220403804580905808353199687552093200830401468286609727129317426388272720408732865327212492031504537174627353565836399714130877312367270078675873457238393131297760481646897679890451976277495690071028209049608193";
 * <p>
 * // 前端的密文
 * String en_text = "327c68bfada2f421d6fe02cc2e90bf4bedde98ca2ac2296e06f711f4da260ccd37ed8c2950484856bf7eabe32496a8945728ff11b3cbf03ea948cda87edd627e769b41d5b4253f7acf1df0d722ccfaa7f4bd74c80bac4ec42e3ae30ca55443470aaa798a9ff94c6e0631da800df1b774aed560087952043cdbf16655639798f6";
 * <p>
 * PrivateKey privateKey = RSAUtil.generateRSAPrivateKey(new BigInteger(modulus), new BigInteger(privateExponent));
 * <p>
 * String de_text = RSAUtil.decryptString(privateKey, en_text);
 * <p>
 * de_text = StringUtils.reverse(de_text);
 * <p>
 * System.out.println(de_text);
 * <p>
 * <p>
 * }
 */

}



