-- 存储过程
set @processname='process_3';
set @cnname='程序3';
set @pinfo='程序3介绍信息';
-- 删除旧程序
DROP PROCEDURE IF EXISTS process_3;
-- 定义结束符
delimiter $
-- 创建程序
create PROCEDURE process_3(in r_id VARCHAR(64))
begin
	DECLARE result_code INTEGER DEFAULT 0; -- 定义返回结果并赋初值0
  DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET result_code=1; -- 在执行过程中出任何异常设置result_code为1
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET result_code = 2; -- 如果表中没有下一条数据则置为2

	-- 业务处理
	UPDATE t_tasks_runtime_process set `status` = '1',start_time = NOW() WHERE id = r_id;
  COMMIT;

	START TRANSACTION; -- 开始事务
	INSERT t_test(id,info,create_time)VALUES(upper(REPLACE(UUID(),'-','')),'2',NOW());

	-- 正常结束
	UPDATE t_tasks_runtime_process set `status` = '2',end_time = NOW() WHERE id = r_id;
	-- 业务处理结束
	IF result_code = 1 THEN -- 可以根据不同的业务逻辑错误返回不同的result_code，这里只定义了1和0
        ROLLBACK;
				UPDATE t_tasks_runtime_process set `status` = '3',end_time = NOW() WHERE id = r_id;
				COMMIT;
  ELSE
        COMMIT;
  END IF;
select result_code;
END $

INSERT INTO `t_tasks_process_info`(`id`, `name`, `process_name`, `param`, `info`, `create_time`, `update_time`)
VALUES (upper(REPLACE(UUID(),'-','')), @cnname, @processname, NULL, @pinfo, NOW(), NOW());
-- 调用存储过程
-- call process_1(1);