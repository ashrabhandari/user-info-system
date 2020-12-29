package com.vastika.uis.controller;

import java.util.List;

import javax.swing.JOptionPane;

import com.vastika.uis.model.User;
import com.vastika.uis.service.UserService;
import com.vastika.uis.service.UserServiceImpl;

public class UserController {

	public static void main(String[] args) {
		UserService userService = new UserServiceImpl();
		String decision = " ";

		do {
			String choice = JOptionPane.showInputDialog("Enter choice: save|update|delete|list|get");
			switch (choice) {
			case "save":
				User user = getUser();
				int saved = userService.saveUserInfo(user);
				if (saved >= 1) {
					JOptionPane.showMessageDialog(null, "User info is saved successfully in DB.");

				} else {
					JOptionPane.showMessageDialog(null, "Error in DB");
				}
				break;
			case "update":
				User updatedUser = getUser();
				int id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				updatedUser.setId(id);
				int updated = userService.updateUserInfo(updatedUser);
				if (updated >= 1) {
					JOptionPane.showMessageDialog(null, "User info is updated successfully in DB.");

				} else {
					JOptionPane.showMessageDialog(null, "Error in DB");
				}
				break;

			case "delete":
				User deletedUser = getUser();
				id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				deletedUser.setId(id);
				int deleted = userService.updateUserInfo(deletedUser);
				if (deleted >= 1) {
					JOptionPane.showMessageDialog(null, "User info is deleted successfully in DB.");

				} else {
					JOptionPane.showMessageDialog(null, "Error in DB");
				}
				break;

			case "list":
				List<User> userList = userService.getAllUserInfo();
				for (User u : userList) {
					System.out.println("User id is: " + u.getId());
					System.out.println("User name is: " + u.getUsername());
					System.out.println("User password is: " + u.getPassword());
					System.out.println("User mobile no is: " + u.getMobileNo());
					System.out.println("User salary is: " + u.getSalary());
					System.out.println("Is user active? : " + u.isActive());
					System.out.println("----------------------------------");

				}
				break;

			case "get":
				id = Integer.parseInt(JOptionPane.showInputDialog("Enter id: "));
				User u = userService.getUserById(id);
				System.out.println("User id is: " + u.getId());
				System.out.println("User name is: " + u.getUsername());
				System.out.println("User password is: " + u.getPassword());
				System.out.println("User mobile no is: " + u.getMobileNo());
				System.out.println("User salary is: " + u.getSalary());
				System.out.println("Is user active? : " + u.isActive());
				System.out.println("----------------------------------");

				break;

			default:
				JOptionPane.showMessageDialog(null, "Wrong Choice");
				break;
			}

			decision = JOptionPane.showInputDialog("Do you want to perform  next operation? Enter yes|no");
		} while (decision.equalsIgnoreCase("yes"));
		JOptionPane.showMessageDialog(null, "GoodBye! Happy Coding! ");

	}

	public static User getUser() {
		User user = new User();
		String username = JOptionPane.showInputDialog("Enter Username: ");
		String password = JOptionPane.showInputDialog("Enter Password: ");
		long mobileNo = Long.parseLong(JOptionPane.showInputDialog("Enter mobile number: "));
		double salary = Double.parseDouble(JOptionPane.showInputDialog("Enter salary "));
		boolean isActive = Boolean.parseBoolean(JOptionPane.showInputDialog("Enter is user active?"));

		user.setUsername(username);
		user.setPassword(password);
		user.setMobileNo(mobileNo);
		user.setActive(isActive);
		user.setSalary(salary);
		return user;
	}
}
