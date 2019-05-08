package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016091900543833";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCBj8uUY7BOdcso8PAtt1Ckb2WMZyR8fSQt54HhYF0Jg4onQicoZJ8GAI+8tjLRZNPqo7iSVHwCdYgvl/c/GDxzzuyCekk5uLwtPhtP0WGhA84j2151mW3dzh0wJFmVYfTxmZRCIjgFwz1Ir84A7hY4kbNeL2gkIoen8LEZUHY7ZTl8FamC+shTi5HcwM/L2+hM/tBelvKu80nntwdTaEyTqqUIRPCmBwcJfm6tzvHiYJD/jz83Ov+3yXcQxl+qqRWMzis03o2hvrqARfxa27UjqTx0SEaB5/l7TskBz5MKxyJgfYdXLR992x5MP53gnHTm6X4hAZzKmJ9Pxy1cv8AzAgMBAAECggEAX7+WEu7tT76rynDs/swX073jjTR4eWu+PhJ2IMonV62XftXbvHVINJZbo3n+6lKabjBaagH3t5WGdK3Y8g8GNgu5K+AVl4vXvZPFeWJixSzbvhITp9Mgp6f4WCi077n53EbEk29YeaHE+5+5HWTWlS3QIg3k57eBC3LMXsng5pkXU6S6Z84oZggZ7l5I1p0YgJKgJV7QQ8KOr7TjCaKO1S2eiZWC/D+YhlfVJUytz7LocBGvZ1J+COwwPlyddCmzDzTsXd+1m/afllb0+MO1F9NdiNSikCXBc/f1K+KGf+MNENVT4TUBDR4Lqh6H/Xcmuf69TWj2xS7LCkofA4A7AQKBgQD9Ff+Bzw17zjCdgx3EsNoQhq3CqNe2P8fQhdQkgbWyqsjJezaKXalaYBu04qU9KeXtJjM/9eoJpv/Qq8+UA8ncTkGEjqy4cY0bCvcmodQtPHubUkcHfinRLMRKCVE13rm8uI/3PkjM03kRnoQ/DHDeRhcwYoBsTTxlUrEEnurRgQKBgQCDDbG87gorBlVIfsiHM9xV1CNOxr7ygY8+Z1aJlYBikf/lwatb+L1iCgV2jzVsdAP3QbwHlHszxfvk/qfcTYXB6nswfqsLy8qpJv4rOvEe1loBf/N+/6OzF/hB0Qb5koW5p/qP0yis9FWEtauAl/M4n0KAKyJLjoZrsyJXSfrDswKBgH/Nxwx/SbjWg9hW6QZ1pHkp+b9OUjhXdwkHO/z/f4jtE54jWYSADdB0riknNvhvGwwp+UF4ZqpfKdnvmVCOpTZaUl2lSvWNagtY+zwIBsSdQXJLF1FiVa2q5KjakacZhUQXE6RwUIUW2ZGbMf9AwhKM5JLrexy12CT2oCvMMJqBAoGABoboE0DHwNzP4oxt8E3k62FlYMcFO464U6NR7AhGHKKo3AiJQEtjIz7chssbHgupJudfNgFvIWT65qzIL3Cs+Lt05zVnz26W6VXH0t9couyKDwkQV4Lj5EeNVbnTXxqtDlIPaJpbrEF/AN0LbZwjwO4tobSEQL8YcsS5MR++HYECgYAINZ9O0bJG360SnmFmME1c4IXPl/ai9ANVVW6cDpuC4VndqfT/0L61avL7o0aar76wB+z4SNSWa5gK8xn1Tfj4r7gfkTPapm5Rcn9aUiQKH/hamjI4FMF3UFAuvwweP0yQjEdAzYMdbdjO0lCsZiQZ2aGFhkIb+8SoHKWJftZsTQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA704Q5YQxwMHRYjuZ2dMW11qV9mrQEu1Sb/KaodQoBGwn5uYBU8fSIoTLgg6cHsC+qZpphEU+ssUjQ2JZLyHoZWj7gcE8W7TiRlg9lvVWZGg3xvw68GPwAwSM/y0ctlIzY4gCCLsimLFsvsu3ayjeXqKYH0V+vY+Q7qb4SRyMGPnPDvszVcIy2vZgM6Q2XwWS44g5TGQWdRO07pbMSBx5A6tALUmaTX9m8Me8bbeEU6U2EwuTFk1xsN3YGLh8hpq8vWAyW0Ly6ciXLf/nO3VGCgos3FOZzYi3K9xD7upZ6tly4H1jwhW116hxJChZQ3XwADkLr3/jBWetAppqS6MKSQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "https://www.vmall.com";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "d:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

