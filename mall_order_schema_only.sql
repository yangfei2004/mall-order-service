-- MySQL dump 10.13  Distrib 8.4.0, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: mall_order
-- ------------------------------------------------------
-- Server version	8.4.5

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `cart_id` bigint NOT NULL AUTO_INCREMENT,
  `bundling_id` int DEFAULT NULL,
  `buy_num` int DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `distribution_orders_id` int DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=829 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cart_bundling`
--

DROP TABLE IF EXISTS `cart_bundling`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart_bundling` (
  `cart_bundling_id` bigint NOT NULL AUTO_INCREMENT,
  `cart_id` int DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`cart_bundling_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `complain`
--

DROP TABLE IF EXISTS `complain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complain` (
  `complain_id` bigint NOT NULL AUTO_INCREMENT,
  `accused_content` varchar(255) DEFAULT NULL,
  `accused_id` int DEFAULT NULL,
  `accused_images` varchar(255) DEFAULT NULL,
  `accused_name` varchar(255) NOT NULL,
  `accused_seller_id` int DEFAULT NULL,
  `accused_time` datetime DEFAULT NULL,
  `accuser_content` varchar(255) NOT NULL,
  `accuser_id` int DEFAULT NULL,
  `accuser_images` varchar(255) DEFAULT NULL,
  `accuser_name` varchar(255) NOT NULL,
  `accuser_time` datetime NOT NULL,
  `admin_check_content` varchar(255) DEFAULT NULL,
  `admin_check_name` varchar(255) DEFAULT NULL,
  `admin_check_time` datetime DEFAULT NULL,
  `admin_confirm_content` varchar(255) DEFAULT NULL,
  `admin_confirm_name` varchar(255) DEFAULT NULL,
  `admin_confirm_time` datetime DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `complain_state` int DEFAULT NULL,
  `goods_full_specs` varchar(255) DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `goods_image` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) NOT NULL,
  `orders_goods_id` int DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `orders_sn` varchar(255) DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  `subject_title` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`complain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `complain_subject`
--

DROP TABLE IF EXISTS `complain_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complain_subject` (
  `subject_id` bigint NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `complain_talk`
--

DROP TABLE IF EXISTS `complain_talk`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complain_talk` (
  `talk_id` bigint NOT NULL AUTO_INCREMENT,
  `complain_id` int DEFAULT NULL,
  `disable_state` int DEFAULT NULL,
  `talk_content` varchar(255) NOT NULL,
  `talk_name` datetime NOT NULL,
  `talk_type` int DEFAULT NULL,
  `talk_user` varchar(255) NOT NULL,
  `user_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`talk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoice` (
  `invoice_id` bigint NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `orders_id` bigint NOT NULL AUTO_INCREMENT,
  `admin_receive_pay_state` int DEFAULT NULL,
  `auto_receive_time` datetime DEFAULT NULL,
  `cancel_reason` int DEFAULT NULL,
  `cancel_role` varchar(255) DEFAULT NULL,
  `cancel_time` datetime DEFAULT NULL,
  `cannot_ship` int DEFAULT NULL,
  `commission_amount` decimal(19,2) DEFAULT NULL,
  `conform_price` decimal(19,2) DEFAULT NULL,
  `coupon_amount` decimal(19,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_time_date` varchar(255) DEFAULT NULL,
  `create_time_hour` varchar(255) DEFAULT NULL,
  `delay_receive_state` int DEFAULT NULL,
  `delete_state` int DEFAULT NULL,
  `evaluation_append_state` int DEFAULT NULL,
  `evaluation_state` int DEFAULT NULL,
  `evaluation_time` datetime DEFAULT NULL,
  `final_amount` decimal(19,2) DEFAULT NULL,
  `finish_time` datetime DEFAULT NULL,
  `freight_amount` decimal(19,2) DEFAULT NULL,
  `go_id` int DEFAULT NULL,
  `group_id` int DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `invoice_code` varchar(255) DEFAULT NULL,
  `invoice_content` varchar(255) DEFAULT NULL,
  `invoice_title` varchar(255) DEFAULT NULL,
  `is_free_freight` int DEFAULT NULL,
  `limit_amount` decimal(19,2) DEFAULT NULL,
  `lock_state` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `orders_amount` decimal(19,2) DEFAULT NULL,
  `orders_from` varchar(255) DEFAULT NULL,
  `orders_from1` varchar(255) DEFAULT NULL,
  `orders_sn` bigint DEFAULT NULL,
  `orders_state` int DEFAULT NULL,
  `orders_type` int DEFAULT NULL,
  `out_orders_sn` varchar(255) DEFAULT NULL,
  `pay_id` int DEFAULT NULL,
  `pay_sn` bigint DEFAULT NULL,
  `payment_client_type` varchar(255) DEFAULT NULL,
  `payment_code` varchar(255) DEFAULT NULL,
  `payment_time` datetime DEFAULT NULL,
  `payment_type_code` varchar(255) DEFAULT NULL,
  `predeposit_amount` decimal(19,2) DEFAULT NULL,
  `reciver_address` varchar(255) DEFAULT NULL,
  `receiver_area_id_1` int DEFAULT NULL,
  `receiver_area_id_2` int DEFAULT NULL,
  `receiver_area_id_3` int DEFAULT NULL,
  `receiver_area_id_4` int DEFAULT NULL,
  `receiver_area_info` varchar(255) DEFAULT NULL,
  `receiver_message` varchar(255) DEFAULT NULL,
  `receiver_name` varchar(255) DEFAULT NULL,
  `receiver_phone` varchar(255) DEFAULT NULL,
  `refund_amount` decimal(19,2) DEFAULT NULL,
  `refund_state` int DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  `ship_code` varchar(255) DEFAULT NULL,
  `ship_name` varchar(255) DEFAULT NULL,
  `ship_note` varchar(255) DEFAULT NULL,
  `orders_note` varchar(255) DEFAULT '',
  `ship_sn` varchar(255) DEFAULT NULL,
  `ship_time_type` int DEFAULT NULL,
  `shop_commitment_amount` decimal(19,2) DEFAULT NULL,
  `store_discount_amount` decimal(19,2) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `store_name` varchar(255) DEFAULT NULL,
  `tax_amount` decimal(19,2) DEFAULT NULL,
  `template_id` int DEFAULT NULL,
  `voucher_code` varchar(255) DEFAULT NULL,
  `voucher_price` decimal(19,2) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`orders_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3400 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders_book`
--

DROP TABLE IF EXISTS `orders_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_book` (
  `book_id` bigint NOT NULL AUTO_INCREMENT,
  `book_amount` decimal(19,2) DEFAULT NULL,
  `book_cancel_time` datetime DEFAULT NULL,
  `book_phone` varchar(255) DEFAULT NULL,
  `book_step` int DEFAULT NULL,
  `cancel_state` int DEFAULT NULL,
  `deposit_amount` decimal(19,2) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `notice_state` int DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `orders_sn` bigint DEFAULT NULL,
  `out_orders_sn` varchar(255) DEFAULT NULL,
  `pay_id` int DEFAULT NULL,
  `pay_sn` bigint DEFAULT NULL,
  `payment_client_type` varchar(255) DEFAULT NULL,
  `payment_code` varchar(255) DEFAULT NULL,
  `payment_time` datetime DEFAULT NULL,
  `predeposit_amount` decimal(19,2) DEFAULT NULL,
  `real_pay_amount` decimal(19,2) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders_gift`
--

DROP TABLE IF EXISTS `orders_gift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_gift` (
  `orders_gift_id` bigint NOT NULL AUTO_INCREMENT,
  `common_id` int DEFAULT NULL,
  `gift_id` int DEFAULT NULL,
  `gift_num` int DEFAULT NULL,
  `gift_type` int DEFAULT NULL,
  `goods_full_specs` varchar(255) DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_serial` varchar(255) DEFAULT NULL,
  `goods_image` varchar(255) DEFAULT NULL,
  `item_common_id` int DEFAULT NULL,
  `item_id` int DEFAULT NULL,
  `orders_goods_id` int DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`orders_gift_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders_goods`
--

DROP TABLE IF EXISTS `orders_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_goods` (
  `orders_goods_id` bigint NOT NULL AUTO_INCREMENT,
  `bargain_open_id` int DEFAULT NULL,
  `base_price` decimal(19,2) DEFAULT NULL,
  `bundling_id` int DEFAULT NULL,
  `buy_num` int DEFAULT NULL,
  `category_id` int DEFAULT NULL COMMENT '分类ID',
  `category_id_1` int DEFAULT NULL,
  `category_id_2` int DEFAULT NULL,
  `category_id_3` int DEFAULT NULL,
  `commission_rate` int DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `complain_id` int DEFAULT NULL,
  `contract` varchar(500) DEFAULT NULL,
  `distribution_orders_id` int DEFAULT NULL,
  `goods_full_specs` varchar(255) DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `goods_image` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_pay_amount` decimal(19,2) DEFAULT NULL,
  `goods_price` decimal(19,2) DEFAULT NULL,
  `goods_serial` varchar(255) DEFAULT NULL,
  `goods_type` int DEFAULT NULL,
  `join_big_sale` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `promotion_title` varchar(10) DEFAULT NULL,
  `refund_price` decimal(19,2) DEFAULT NULL,
  `seckill_goods_id` int DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `tax_amount` decimal(19,2) DEFAULT NULL,
  `tax_rate` decimal(19,2) DEFAULT NULL,
  `trys_apply_id` int DEFAULT NULL,
  `unit_name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`orders_goods_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3829 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders_pay`
--

DROP TABLE IF EXISTS `orders_pay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_pay` (
  `pay_id` bigint NOT NULL AUTO_INCREMENT,
  `coupon_id` varchar(255) DEFAULT NULL,
  `coupon_return` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `pay_orders_type` int DEFAULT NULL,
  `pay_sn` bigint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`pay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3400 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `orders_seckill`
--

DROP TABLE IF EXISTS `orders_seckill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_seckill` (
  `orders_seckill_id` bigint NOT NULL AUTO_INCREMENT,
  `buy_num` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `seckill_goods_id` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`orders_seckill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT,
  `client_type` varchar(255) DEFAULT NULL,
  `client_type_text` varchar(255) DEFAULT NULL,
  `payment_code` varchar(255) DEFAULT NULL,
  `payment_info` varchar(255) DEFAULT NULL,
  `payment_name` varchar(255) DEFAULT NULL,
  `payment_state` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refund`
--

DROP TABLE IF EXISTS `refund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refund` (
  `refund_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `admin_message` varchar(255) DEFAULT NULL,
  `admin_time` datetime DEFAULT NULL,
  `bill_time` datetime DEFAULT NULL,
  `buyer_message` varchar(255) DEFAULT NULL,
  `commission_rate` int DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `coupon_amount` decimal(19,2) DEFAULT NULL,
  `delay_time` datetime DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `goods_image` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_num` int DEFAULT NULL,
  `goods_state` int DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `order_goods_type` int DEFAULT NULL,
  `order_lock` int DEFAULT NULL,
  `orders_goods_id` int DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `orders_sn` bigint DEFAULT NULL,
  `orders_type` int DEFAULT NULL,
  `pic_json` longtext,
  `reason_id` int DEFAULT NULL,
  `reason_info` varchar(255) DEFAULT NULL,
  `receive_message` varchar(255) DEFAULT NULL,
  `receive_time` datetime DEFAULT NULL,
  `refund_amount` decimal(19,2) DEFAULT NULL,
  `refund_sn` bigint DEFAULT NULL,
  `refund_state` int DEFAULT NULL,
  `refund_type` int DEFAULT NULL,
  `return_type` int DEFAULT NULL,
  `seller_message` varchar(255) DEFAULT NULL,
  `seller_state` int DEFAULT NULL,
  `seller_time` datetime DEFAULT NULL,
  `ship_id` int DEFAULT NULL,
  `ship_sn` varchar(255) DEFAULT NULL,
  `ship_time` datetime DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `store_name` varchar(255) DEFAULT NULL,
  `refund_source` int DEFAULT '1',
  `admin_state` int DEFAULT '1',
  `refund_member_cancel` int DEFAULT '0',
  `return_member_auto_cancel` int DEFAULT '0',
  `return_seller_auto_receive` int DEFAULT '0',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`refund_id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refund_book`
--

DROP TABLE IF EXISTS `refund_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refund_book` (
  `refund_book_id` bigint NOT NULL AUTO_INCREMENT,
  `batch_no` varchar(255) DEFAULT NULL,
  `book_step` varchar(255) DEFAULT NULL,
  `out_orders_sn` varchar(255) DEFAULT NULL,
  `out_refund_id` varchar(255) DEFAULT NULL,
  `pay_amount` decimal(19,2) DEFAULT NULL,
  `pay_sn` bigint DEFAULT NULL,
  `payment_client_type` varchar(255) DEFAULT NULL,
  `payment_code` varchar(255) DEFAULT NULL,
  `payment_time` datetime DEFAULT NULL,
  `refund_amount` decimal(19,2) DEFAULT NULL,
  `refund_id` int DEFAULT NULL,
  `refund_sn` bigint DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`refund_book_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refund_detail`
--

DROP TABLE IF EXISTS `refund_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refund_detail` (
  `refund_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `batch_no` varchar(255) DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `pay_amount` decimal(19,2) DEFAULT NULL,
  `pay_time` datetime DEFAULT NULL,
  `pd_amount` decimal(19,2) DEFAULT NULL,
  `rcb_amount` decimal(19,2) DEFAULT NULL,
  `refund_amount` decimal(19,2) DEFAULT NULL,
  `refund_code` varchar(255) DEFAULT NULL,
  `refund_state` int DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`refund_id`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refund_reason`
--

DROP TABLE IF EXISTS `refund_reason`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refund_reason` (
  `reason_id` bigint NOT NULL AUTO_INCREMENT,
  `reason_info` varchar(100) DEFAULT NULL,
  `reason_sort` int DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`reason_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refund_virtual`
--

DROP TABLE IF EXISTS `refund_virtual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refund_virtual` (
  `refund_id` bigint NOT NULL AUTO_INCREMENT,
  `add_time` datetime DEFAULT NULL,
  `admin_content` varchar(255) DEFAULT NULL,
  `admin_time` datetime DEFAULT NULL,
  `batch_no` varchar(255) DEFAULT NULL,
  `buyer_content` varchar(255) DEFAULT NULL,
  `common_id` int DEFAULT NULL,
  `coupon_amount` decimal(19,2) DEFAULT NULL,
  `goods_full_specs` varchar(255) DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `goods_image` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `online_amount` decimal(19,2) DEFAULT NULL,
  `orders_goods_id` int DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `orders_sn` bigint DEFAULT NULL,
  `out_orders_sn` varchar(255) DEFAULT NULL,
  `payment_code` varchar(255) DEFAULT NULL,
  `refund_amount` decimal(19,2) DEFAULT NULL,
  `refund_sn` bigint DEFAULT NULL,
  `refund_state` int DEFAULT NULL,
  `refund_time` datetime DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `store_name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`refund_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refund_virtual_code`
--

DROP TABLE IF EXISTS `refund_virtual_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refund_virtual_code` (
  `refund_code_id` bigint NOT NULL AUTO_INCREMENT,
  `common_id` int DEFAULT NULL,
  `goods_code` varchar(255) DEFAULT NULL,
  `goods_id` int DEFAULT NULL,
  `goods_image` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `member_id` int DEFAULT NULL,
  `member_name` varchar(255) DEFAULT NULL,
  `orders_code_id` int DEFAULT NULL,
  `orders_goods_id` int DEFAULT NULL,
  `orders_id` int DEFAULT NULL,
  `orders_sn` bigint DEFAULT NULL,
  `refund_amount` decimal(19,2) DEFAULT NULL,
  `refund_id` int DEFAULT NULL,
  `refund_sn` bigint DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `store_name` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`refund_code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ship_company`
--

DROP TABLE IF EXISTS `ship_company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ship_company` (
  `ship_id` bigint NOT NULL AUTO_INCREMENT,
  `ship_code` varchar(15) DEFAULT NULL,
  `ship_letter` varchar(255) DEFAULT NULL,
  `ship_name` varchar(255) DEFAULT NULL,
  `ship_state` int DEFAULT NULL,
  `ship_type` int DEFAULT NULL,
  `ship_url` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `created_by` bigint DEFAULT NULL,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_by` bigint DEFAULT NULL,
  `is_deleted` tinyint DEFAULT '0',
  PRIMARY KEY (`ship_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-07  6:02:44
