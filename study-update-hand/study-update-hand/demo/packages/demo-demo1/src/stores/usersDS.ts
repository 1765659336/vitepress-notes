/* import { DataSet } from 'choerodon-ui/pro';
import { useMemo } from 'react';

// 使用上章 DS 配置，new DS 实例
export const tableDS2 = useMemo(()=> {
  return new DataSet ({
    // 指定 DataSet 初始化后自动查询
    autoQuery: true,
    // 主键字段名，一般用作级联行表的查询字段
    primaryKey: 'key',
    // 对应后端接口，自动生成约定的 submitUrl, queryUrl...
    name: 'user',
    pageSize: 8,
    // 数据对象名，默认值 'rows'
    dataKey: 'content',
    // DataSet 中包含的字段，对应上述后端数据中每条记录中的字段
    fields: [
        { name: 'name', type: 'string' , label: '姓名', help: '唯一的主键，不能修改' },
        { name: 'age', type: 'number' , label: '年龄', max: 100, min: 1, step: 1},
        { name: 'address', type: 'string' , label: '地址'},
    ],
    // data,
    queryUrl:'http://localhost:8000/api/v1/query',
    transport: {
      submit: 'http://localhost:8000/api/v1/submit',
      destroy: 'http://localhost:8000/api/v1/delete'
    }
})
}, []);

 // 表格列配置
export const columns2 = useMemo(() => {
  return [
    { name: 'name', editor: true },
    { name: 'age', editor: true },
    { name: 'address', editor: true },
  ];
}, []); */