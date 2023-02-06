import { getAllStudents } from './client';

import './App.css';
import React, { useState } from 'react';
import { useEffect } from 'react';

import {
  DesktopOutlined,
  FileOutlined,
  PieChartOutlined,
  TeamOutlined,
  UserOutlined,
  LoadingOutlined,
} from '@ant-design/icons';
  import { Breadcrumb, Layout, Menu, Table, Spin, Empty} from 'antd';

const { Header, Content, Footer, Sider } = Layout;
const { SubMenu } = Menu;



// type MenuItem = Required<MenuProps>['items'][number];

// function getItem(
//   label: React.ReactNode,
//   key: React.Key,
//   icon?: React.ReactNode,
//   children?: MenuItem[],
// ): MenuItem {
//   return {
//     key,
//     icon,
//     children,
//     label,
//   } as MenuItem;
// }

// const items: MenuItem[] = [
//   getItem('Option 1', '1', <PieChartOutlined />),
//   getItem('Option 2', '2', <DesktopOutlined />),
//   getItem('User', 'sub1', <UserOutlined />, [
//     getItem('Tom', '3'),
//     getItem('Bill', '4'),
//     getItem('Alex', '5'),
//   ]),
//   getItem('Team', 'sub2', <TeamOutlined />, [getItem('Team 1', '6'), getItem('Team 2', '8')]),
//   getItem('Files', '9', <FileOutlined />),
// ];

const columns = [
  {
    title: 'Id',
    dataIndex: 'id',
    key: 'id',
  },
  {
    title: 'Name',
    dataIndex: 'name',
    key: 'name',
  },
  {
    title: 'Email',
    dataIndex: 'email',
    key: 'email',
  },
  {
    title: 'Gender',
    dataIndex: 'gender',
    key: 'gender',
  }
];


const antIcon = <LoadingOutlined style={{ fontSize: 24 }} spin />

function App() {

  const [students, setStudents] = useState([]);
  const [collapsed, setCollapsed] = useState(false);
  const [fetching, setFetching] = useState(true);


  const fetchStudents = () =>
  getAllStudents()
    .then(res => res.json())
    .then(data => {
      console.log(data);
      setStudents(data)
      setFetching(false);
    });

  useEffect(() => {
   console.log("Component is mounted");
   fetchStudents();
  }, []);



const renderStudents = () => {
  if(fetching) {
    return <Spin indicator={antIcon} />
  }
  if(students.length <= 0) {
    return <Empty />;
  } 
  return <Table 
  dataSource={students} 
  columns={columns}
  bordered
  title={() => 'Students'}
  pagination={{ pageSize: 50 }}
  scroll={{ y: 240 }}
  rowKey={(student) => student.id}
  />
}
 

  return  <Layout style={{ minHeight: '100vh' }}>
  <Sider collapsible collapsed={collapsed} 
  onCollapse={setCollapsed}>
    <div className="logo" />
    <Menu theme="dark" defaultSelectedKeys={['1']} mode="inline">
      <Menu.Item key="1" icon={<PieChartOutlined />}>
        Option 1
      </Menu.Item>
      <Menu.Item key="2" icon={<DesktopOutlined />}>
        Option 2
      </Menu.Item>
      <SubMenu key="sub1" icon={<UserOutlined/>} title="User">
        <Menu.Item key="3">Ton</Menu.Item>
        <Menu.Item key="4">Bill</Menu.Item>
        <Menu.Item key="5">Alex</Menu.Item>
      </SubMenu>
      <SubMenu key="sub2" icon={<TeamOutlined/>} title="Team">
        <Menu.Item key="6">Team</Menu.Item>
        <Menu.Item key="8">Team</Menu.Item>
      </SubMenu>
      <Menu.Item key="9" icon={<FileOutlined/>}>
        Files
        </Menu.Item>
    </Menu>
  </Sider>
  <Layout className="site-layout">
    <Header className="site-layout-background" style={{ padding: 0 }} />
    <Content style={{ margin: '0 16px' }}>
      <Breadcrumb style={{ margin: '16px 0' }}>
        <Breadcrumb.Item>User</Breadcrumb.Item>
        <Breadcrumb.Item>Bill</Breadcrumb.Item>
      </Breadcrumb>
      <div className="site-layout-background" style={{ padding: 24, minHeight: 360 }}>
       {renderStudents(students)}
      </div>
    </Content>
    <Footer style={{ textAlign: 'center' }}>By DialloDeveloper ©2023 </Footer>
  </Layout>
</Layout>;
}

export default App;
