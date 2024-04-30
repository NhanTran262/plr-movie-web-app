import React, { ReactNode } from 'react'

export interface RouteData {
  path: string;
  element: React.ComponentType<any>;
  layout: React.ComponentType<any>;
  children?: RouteData[];
}

export interface LayoutProps {
  children: ReactNode
}

export interface MenuItem {
  icon: React.ReactNode;
  iconActive: React.ReactNode;
  title: string;
  url: string;
  active: boolean;
}

export interface TrailerMenu {
  id: number;
  name: string;
  link: string;
}
