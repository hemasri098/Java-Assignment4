package com.company;
import org.junit.Assert;

public class TestKYCForm {
        public static void test() {
            KYCForm kycForm = new KYCForm();
            Assert.assertEquals("16-06-2017 27-06-2017", kycForm.provideRange(new String[]{"16-07-1998", "27-06-2017"}));
            Assert.assertEquals("No range", kycForm.provideRange(new String[]{"04-05-2017", "04-04-2017"}));

        }
}

